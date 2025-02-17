#!/bin/bash

git_status=$(git status --porcelain)

if [[ -z "$git_status" ]]; then
  echo -e "\e[33mNo changes detected to commit. Exiting...\e[39m"
  read -n 1 -s
  exit 0
fi

commit_mods_only=false
commit_message="Done $task_number."
task_number=""

while [[ $# -gt 0 ]]; do
  case "$1" in
    -m|-M)
      commit_mods_only=true
      shift
      ;;
    -msg)
      if [[ -n "$2" ]]; then
        commit_message="$2"
        shift 2
      else
        echo -e "\e[31mERROR\e[39m"
        echo "Missing commit message after -msg flag"
        read -n 1 -s
        exit 1
      fi
      ;;
    -h|--help)
      cat << EOF
Usage: ./pre_action.sh [options] [task_number]

This script automates git add, commit, and push operations.

Options:
  -m|-M           ModsOnly mode. TShould be used when no files are added.
  -msg "message"  Specify a custom commit message. Use quotes for messages with spaces.
  -h|--help       Display this help message.

Arguments:
  task_number    The task number associated with the commit. If not provided, an
                 attempt to auto-detect it is performed. In case of a failure,
                 it will prompt to switch to the ModsOnly mode.

Examples:
  ./pre_action.sh                        Commit all changes with auto-detected task number.
  ./pre_action.sh 123                    Commit all changes with task number 123.
  ./pre_action.sh -m 456                 Commit only modifications with task number 456.
  ./pre_action.sh -msg "Bug fix"         Commit all changes with custom message.
  ./pre_action.sh -m -msg "Refactor" 789 Commit modifications only with custom message and task number.
EOF
      read -n 1 -s
      exit 0
      ;;
    *)
      if [[ -z "$task_number" ]]; then
        task_number="$1"
        echo -e "\e[36mUsing provided task number: $task_number\e[39m"
      else
        echo -e "\e[31mERROR\e[39m"
        echo "Multiple task numbers provided."
        read -n 1 -s
        exit 1
      fi
      shift
      ;;
  esac
done

if ! $commit_mods_only; then
  if [[ -z "$task_number" ]]; then
    echo -e "\e[36mNo task number provided, attempting automatic detection...\e[39m"
    task_number=$(git status | grep -Eo 'new file:.*_[0-9]+' | head -n 1 | grep -Eo '_[0-9]+' | grep -Eo '[0-9]+')
  fi

  if [[ -z "$task_number" ]]; then
    echo -e "\e[31mERROR\e[39m"
    echo "Auto-detection failed. Would you like to switch to the ModsOnly mode? (y/n)"
    read -n 1 user_choice
    if [[ "$user_choice" == "y" ]]; then
      commit_mods_only=true
      task_number="Modifications Only"
      echo -e "\e[36mProceeding in the ModsOnly mode. Please enter a commit message (or press Enter for default): \e[39m"
      read commit_message_input
      if [[ -n "$commit_message_input" ]]; then
        commit_message="$commit_message_input"
      fi
      echo -e "\e[36mYielding commit message: $commit_message\e[39m"
    else
      echo -e "\e[31mCommit aborted."
      read -n 1 -s
      exit 1
    fi
  fi
fi

if $commit_mods_only && [[ -z "$task_number" ]]; then
    task_number="Modifications Only"
fi

if ! $commit_mods_only && [[ -z "$1" ]]; then
      echo -e "\e[36mTask number (auto-detected): $task_number\e[39m"
  elif $commit_mods_only; then
      echo -e "\e[36mNo task number is used.\e[39m"
  elif ! $commit_mods_only && [[ -z "$task_number" ]]; then # This is always false
      echo -e "\e[31mERROR\e[39m"
      echo "Could not proceed without a task number. Please provide one or ensure new files are named correctly."
      read -n 1 -s
      exit 1
  else
      echo -e "\e[36mTask number: $task_number\e[39m"
  fi

branch_name=$(git branch --show-current)

if $commit_mods_only; then
  echo -e "\e[94mCommitting in ModsOnly mode to the $branch_name...\e[39m"
else
  echo -e "\e[94mCommitting to the $branch_name...\e[39m"
fi

git add .
git commit -m "$commit_message"

echo -e "\e[94mPushing the changes...\e[39m"
git push --set-upstream origin "$branch_name"

echo -e "\e[32mSUCCESS\e[39m"
read -n 1 -s
exit 0