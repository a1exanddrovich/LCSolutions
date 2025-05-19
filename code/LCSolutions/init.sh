#!/bin/bash

# Script that initializes a new task package by copying initial files.
# Takes the full task name and topic name as options.
# Copies content from the templated Main and Solution files, updating its package declaration.
# Conditionally replaces digits found in the task name with words to keep names consistent
# and auto-executes stages in git.
# Requires configuration via a "Projectfile".

CONFIG_FILE="Projectfile"

if [ ! -f "$CONFIG_FILE" ]; then
    echo -e "\e[31mERROR: Configuration file '$CONFIG_FILE' not found.\e[39m"
    echo -e "\e[36mPlease create a file named '$CONFIG_FILE' with the necessary config.\e[39m"
    read -n 1 -s
    exit 1
fi

source "$CONFIG_FILE"
echo -e "\e[36mLoaded configuration from $CONFIG_FILE\e[39m"

if [ -z "$BASE_DIR" ] || [ -z "$BASE_PACKAGE" ]; then
    echo -e "\e[31mError: Required 'BASE_DIR' and 'BASE_PACKAGE' not found.\e[39m"
    echo -e "\e[36mPlease ensure required vars are defined and exported in '$CONFIG_FILE'.\e[39m"
    read -n 1 -s
    exit 1
fi

BASE_DIR="$BASE_DIR"
BASE_PACKAGE="$BASE_PACKAGE"
DIGITS_NAME_FALLBACK="${DIGITS_NAME_FALLBACK:-false}"
AUTO_GITSTAGED="${AUTO_GITSTAGED:-false}"

echo -e "\e[94mUsing BASE_DIR: $BASE_DIR\e[39m"
echo -e "\e[94mUsing BASE_PACKAGE: $BASE_PACKAGE\e[39m"
echo -e "\e[94mConvert Digits to Words: $DIGITS_NAME_FALLBACK\e[39m"
echo -e "\e[94mAuto Stage Git: $AUTO_GITSTAGED\e[39m"

OPTS=$(getopt -o n:t: --long name:,topic: -n "$0" -- "$@")

if [ $? -ne 0 ]; then
    echo -e "\e[31mError: Invalid command line options.\e[39m" >&2
    echo -e "\e[36mUsage: [-n|--name] \"<task_full_name>\" [-t|--topic] <topic_name>\e[39m" >&2
    read -n 1 -s
    exit 1
fi

eval set -- "$OPTS"

TASK_FULL=""
TOPIC_NAME=""

while true; do
    case "$1" in
        -n|--name)
            TASK_FULL="$2"
            shift 2
            ;;
        -t|--topic)
            TOPIC_NAME="$2"
            shift 2
            ;;
        --)
            shift
            break
            ;;
        *)
            echo -e "\e[31mError: Internal error while parsing options.\e[39m" >&2
            exit 1
            ;;
    esac
done

if [ -z "$TASK_FULL" ] || [ -z "$TOPIC_NAME" ]; then
    echo -e "\e[31mError: Both task name (-n/--name) and topic name (-t/--topic) are required.\e[39m" >&2
    echo -e "\e[36mUsage: $0 [-n|--name] \"<task_full_name_with_number>\" [-t|--topic] <topic_name>\e[39m" >&2
    read -n 1 -s
    exit 1
fi

TOPIC_PATH="$BASE_DIR/$TOPIC_NAME"

# Split the full task name at the first dot to figure out the task number and the task name
IFS='.' read -r TASK_NUMBER_WITH_SUFFIX TASK_NAME_WITH_SUFFIX <<< "$TASK_FULL"

TASK_NUMBER=$(echo "$TASK_NUMBER_WITH_SUFFIX" | grep -oE '^[0-9]+')

TASK_NAME_BASE=$(echo "$TASK_NAME_WITH_SUFFIX" | sed -e 's/^\s*//' -e 's/\s*$//')

if [ "$DIGITS_NAME_FALLBACK" = "true" ]; then
    TASK_NAME_CONVERTED=$(echo "$TASK_NAME_BASE" |
        sed -e 's/0/zero/g' -e 's/1/one/g' -e 's/2/two/g' -e 's/3/three/g' -e 's/4/four/g' \
            -e 's/5/five/g' -e 's/6/six/g' -e 's/7/seven/g' -e 's/8/eight/g' -e 's/9/nine/g')
    TASK_NAME_SANITIZED=$(echo "$TASK_NAME_CONVERTED" | sed -e 's/[^a-zA-Z0-9]//g' | tr '[:upper:]' '[:lower:]')
else
    TASK_NAME_SANITIZED=$(echo "$TASK_NAME_BASE" | sed -e 's/[^a-zA-Z0-9]//g' | tr '[:upper:]' '[:lower:]')
fi

TASK_DIR_NAME="${TASK_NAME_SANITIZED}_${TASK_NUMBER}"
TARGET_DIR="$BASE_DIR/$TOPIC_NAME/$TASK_DIR_NAME"

# If duplicate dir found
if [ -d "$TARGET_DIR" ]; then
    echo -e "\e[31mError: Directory '$TARGET_DIR' already exists.\e[39m"
    read -n 1 -s
    exit 1
fi

# Find the first subdir to copy from within the specified topic (excluding the topic itself)
EXISTING_SOURCE_SUBDIR=$(find "$TOPIC_PATH" -maxdepth 1 -type d -not -name "." -not -name ".." -not -name "$(basename "$TOPIC_PATH")" | head -n 1)

echo -e "\e[36m$EXISTING_SOURCE_SUBDIR is being used as a template...\e[39m"

if [ -z "$EXISTING_SOURCE_SUBDIR" ]; then
    echo -e "\e[31mError: No existing subdir found in the topic '$TOPIC_NAME' to copy from.\e[39m"
    echo -e "\e[36mPlease ensure there is at least one existing task package within the '$TOPIC_NAME' directory.\e[39m"
    read -n 1 -s
    exit 1
fi

SOURCE_MAIN="$EXISTING_SOURCE_SUBDIR/Main.java"
SOURCE_SOLUTION="$EXISTING_SOURCE_SUBDIR/Solution.java"

echo -e "\e[94mChecking for source files...\e[39m"

if [ ! -f "$SOURCE_MAIN" ] || [ ! -f "$SOURCE_SOLUTION" ]; then
    echo -e "\e[31mError: Could not find Main.java or Solution.java in the expected location.\e[39m"
    echo -e "\e[36mExpected paths: '$SOURCE_MAIN' and '$SOURCE_SOLUTION'.\e[39m"
    read -n 1 -s
    exit 1
fi

mkdir -p "$TARGET_DIR"

cp "$SOURCE_MAIN" "$TARGET_DIR/"
cp "$SOURCE_SOLUTION" "$TARGET_DIR/"

BASE_PACKAGE="$BASE_PACKAGE"

OLD_PACKAGE_NAME=$(grep "^package " "$SOURCE_MAIN" | head -n 1 | awk '{print $2}' | sed 's/;//')

# Replace the old package name with the new TASK_DIR_NAME in the copied files
if [ ! -z "$OLD_PACKAGE_NAME" ]; then
    find "$TARGET_DIR" -name "Main.java" -exec sed -i "s/package $OLD_PACKAGE_NAME;/package $BASE_PACKAGE.$TOPIC_NAME.$TASK_DIR_NAME;/" {} \;
    find "$TARGET_DIR" -name "Solution.java" -exec sed -i "s/package $OLD_PACKAGE_NAME;/package $BASE_PACKAGE.$TOPIC_NAME.$TASK_DIR_NAME;/" {} \;
else
    echo -e "\e[36mCould not determine the old package name. Package declaration in copied files might need manual update.\e[39m"
fi

echo -e "\e[32mSuccessfully executed the initialization\e[39m"

if [ "$AUTO_GITSTAGED" = "true" ]; then
    if git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
        git add "$TARGET_DIR"
        echo -e "\e[94mAuto-executing the git staging...\e[39m"
    else
        echo -e "\e[36mWarning: Auto-stage is enabled, but not in a the git repo. Skipping...\e[39m"
    fi
fi

echo -e "\e[32mSUCCESS\e[39m"
read -n 1 -s
exit 0
