#!/bin/sh

### [Terminal 1] Set wildfly version and base dir
source ./0-include.sh

### [Terminal 1] Clone and build wildfly vertx extension project
cd $BASE_DIR
git clone https://github.com/gaol/wildfly-vertx-extension
cd wildfly-vertx-extension
mvn clean install

### [Terminal 1] Use galleon to apply vertx extension feature pack to provisioned wildfly
cd $BASE_DIR
galleon install --file=wildfly-vertx-extension/galleon-feature-pack/target/wildfly-vertx-feature-pack-1.0.0-SNAPSHOT.zip --dir=wildfly-$WILDFLY_VERSION

