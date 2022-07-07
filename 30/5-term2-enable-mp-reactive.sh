#!/bin/sh

### [Terminal 2] Set wildfly version and base dir
source ./0-include.sh

### [Terminal 2] Clone microprofile reactive messaging kafka quickstart
cd $BASE_DIR
git clone https://github.com/wildfly/quickstart

### [Terminal 2] Enable microprofile reactive messaging and reactive streams operators subsystems
wildfly-$WILDFLY_VERSION/bin/jboss-cli.sh --connect --file=quickstart/microprofile-reactive-messaging-kafka/enable-reactive-messaging.cli

