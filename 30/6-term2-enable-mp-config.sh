#!/bin/sh

### [Terminal 2] Set wildfly version and base dir
source ./0-include.sh

### [Terminal 2] Enable microprofile config subsystems
cd $BASE_DIR
cat << EOF > quickstart/microprofile-reactive-messaging-kafka/enable-config.cli
batch
/extension=org.wildfly.extension.microprofile.config-smallrye:add
/subsystem=microprofile-config-smallrye:add
run-batch

reload
EOF
wildfly-$WILDFLY_VERSION/bin/jboss-cli.sh --connect --file=quickstart/microprofile-reactive-messaging-kafka/enable-config.cli

