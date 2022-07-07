#!/bin/sh

### [Terminal 2] Set wildfly version and base dir
source ./0-include.sh

### [Terminal 2] Start kafka and zookeeper
cd $BASE_DIR
cd quickstart/microprofile-reactive-messaging-kafka
docker-compose up

