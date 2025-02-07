#!/bin/bash

git_status=$(git status --porcelain)

if [[ -z "$git_status" ]]; then
  echo -e "\e[33mNo changes detected to commit. Exiting...\e[39m"
  read -n 1 -s
  exit 0
fi

if [[ -z "$1" ]]; then
  echo -e "\e[36mNo task number provided, determining programmatically...\e[39m"
  task_number=$(git status | grep -Eo 'new file:.*_[0-9]+' | head -n 1 | grep -Eo '_[0-9]+' | grep -Eo '[0-9]+')
else
  task_number="$1"
  echo -e "\e[36mUsing provided task number...\e[39m"
fi

if [[ -z "$task_number" ]]; then
    echo -e "\e[31mERROR\e[39m"
    echo "Could not proceed without a task number"
    read -n 1 -s
    exit 1
fi

echo -e "\e[36mTask number being used: $task_number\e[39m"

branch_name=$(git branch --show-current)

git add .

echo -e "\e[94mCommitting to the $branch_name...\e[39m"
git commit -m "Done $task_number."

echo -e "\e[94mPushing the changes...\e[39m"
git push --set-upstream origin "$branch_name"

echo -e "\e[32mSUCCESS\e[39m"
read -n 1 -s
exit 0
