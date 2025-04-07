#!/bin/bash

git_status=$(git status --porcelain)

if [[ -n "$git_status" ]]; then
  echo -e "\e[33mWARNING: There are uncommitted changes in the repo.\e[39m"
  echo "$git_status"
  read -p "Do you want to continue anyway? (y/N): " choice

  case "$choice" in
    y|Y )
      echo -e "\e[95mNow way to continue with uncommitted changes:)\e[39m"
      read -n 1 -s
      exit 1
      ;;
    * )
      echo -e "\e[31mAborting due to uncommitted changes.\e[39m"
      read -n 1 -s
      exit 1
      ;;
  esac
fi

prev_branch_name=$(git branch | grep "*" | cut -d ' ' -f2)

echo -e "\e[36mRetrieved prev branch name: $prev_branch_name\e[39m"

if [[ $prev_branch_name =~ ^[^-]*-([0-9]+)$ ]]; then
  prev_branch_number=${BASH_REMATCH[1]}
else
  echo -e "\e[31mERROR\e[39m"
  echo "Could not proceed as problems with prev branch name have been detected"
  read -n 1 -s
  exit 1
fi

next_branch_number=$(expr "$prev_branch_number" + 1)
next_branch_name="dev-${next_branch_number}"

echo -e "\e[94mSynchronizing the repo...\e[39m"
git checkout dev-1

git_pull_output=$(git pull origin dev-1 2>&1)

if [[ $? -eq 0 ]]; then
  if [[ "$git_pull_output" == *"Already up to date."* ]]; then
    echo -e "\e[33mRepo is already up to date.\e[39m"
    git checkout "$prev_branch_name"
    read -n 1 -s
    exit 0
  fi
else
  echo -e "\e[31mERROR: Git pull failed.\e[39m"
  echo "$git_pull_output"
  # Restore to the previous state before the post actions began
  git checkout "$prev_branch_number"
  read -n 1 -s
  exit 1
fi

echo -e "\e[94mPreparing the repo...\e[39m"
git branch -d "$prev_branch_name"
git checkout -b "$next_branch_name"

echo -e "\e[32mSUCCESS\e[39m"
read -n 1 -s
exit 0
