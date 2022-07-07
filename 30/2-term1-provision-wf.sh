#!/bin/sh


### [Terminal 1] Set wildfly version and base dir
source ./0-include.sh

### [Terminal 1] Use galleon to provision wildfly, matching version in vertx extension project
cd $BASE_DIR
galleon install wildfly:current#$WILDFLY_VERSION --dir=wildfly-$WILDFLY_VERSION

