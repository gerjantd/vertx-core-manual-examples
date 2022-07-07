#!/bin/sh

### [Terminal 1] Set wildfly version and base dir
source ./0-include.sh

### [Terminal 1] Start wildfly
cd $BASE_DIR
wildfly-$WILDFLY_VERSION/bin/standalone.sh -c standalone-vertx.xml

