#!/bin/sh

### [Terminal 3] Set wildfly version and base dir
source ./0-include.sh

### [Terminal 3] Build and deploy microprofile reactive messaging kafka quickstart
cd $BASE_DIR
cd quickstart/microprofile-reactive-messaging-kafka
mvn clean package wildfly:deploy

