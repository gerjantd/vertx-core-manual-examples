#!/bin/sh

source ./0-include.sh

if [ -d $BASE_DIR ]; then
  echo "$BASE_DIR exists; do you want to continue?"
  read -p "Press Ctrl+C to abort, any other key to continue"
  rm -rf $BASE_DIR
fi
mkdir $BASE_DIR
