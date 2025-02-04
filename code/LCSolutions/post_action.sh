#!/bin/bash

# Detecting the prev branch name. May be done with git branch --show-current
prev_branch_name=$(git branch | grep "*" | cut -d ' ' -f2)
echo -e "\e[36mRetrieved prev branch name: $prev_branch_name\e[39m"

# Check if current branch has a number suffix
if [[ $prev_branch_name =~ ^[^-]*-([0-9]+)$ ]]; then
  # Extract this number using regular expression
  prev_branch_number=${BASH_REMATCH[1]}
else
  echo -e "\e[31mERROR\e[39m"
  echo "Could not proceed as problems with prev branch name have been detected"
  while true; do sleep 1; done
fi

next_branch_number=$(expr "$prev_branch_number" + 1)
next_branch_name="dev-${next_branch_number}"

echo -e "\e[93mSynchronizing the repo...\e[39m"
git checkout dev
git pull

echo -e "\e[93mPreparing the repo...\e[39m"
git branch -d $prev_branch_name
git checkout -b $next_branch_name

echo -e "\e[32mSUCCESS\e[39m"
while true; do sleep 1; done