# Module 30

## Description

As Module 29, with trivial example of CDI access to vertx instance (29 recap: Merge Wildfly Vert.x Extension example webapp with Wildfly Microprofile Reactive Messaging Kafka quickstart (deploy on Wildfly with Vert.x and Microprofile Reactive Messaging enabled)).

## Notes

* Does not use parent pom.xml unlike module 28.
* Does not use tests from either example webapp (module 28) or quickstart. 

## References

### Related mail

Ger-Jan te Dorsthorst <gtedorst@redhat.com>
Mon, Jul 4, 11:08 PM 
to Lin
Hi Lin,
On Thu, May 19, 2022 at 7:00 AM Lin Gao <lgao@redhat.com> wrote:
    On Wed, May 18, 2022 at 10:09 PM Ger-Jan te Dorsthorst <gtedorst@redhat.com> wrote:
        >  (1) Basically yes. Another benefit of the extension is that having the Vert.x instance managed by WildFly server makes it easy to configure by different roles than the application developers, especially in the case of clustered Vert.x to communicate with remote Vert.x instances.
        > (2) I talked with Kabir Khan some days ago about this extension too, the use case from him is that it is possible to call SQL operations using vertx-sql-client in reactive way on some inbound messages like kafka messages from the expansion package, and it is possible to choose which Vert.x instance to use. (The underground of expansion package like reactive-messaging relies on Vert.x a lot)
        It would be great if we had 1 or a few quickstarts demonstrating these use cases. If I am correct, the things you mention are examples of something that can not (or not as easily) be achieved in vanilla Wildfly (2), and plain Vert.x (1).
    I think an example of one clustered Vert.x usage in 2 applications can demonstrate the benefits of this extension,  and I will work with that. This can not be achieved in vanilla WildFly.
    For point (2), it needs extra effort to make it work and it is on my plan, I need to figure out how reactive-messaging can integrate with this extension to access the Vert.x instance.
I've been playing a bit with integrating Kabir's reactive messaging pack with your vertx extension, and it seems to work well.
Basically I went through these steps.
1. Use galleon to provision wildfly 26.0.1 (= your current extension wildfly version)
2. Build the vertx extension and apply the feature pack
3. Start wildfly with standalone-vertx
4. Clone the reactive messaging quickstart at https://github.com/wildfly/quickstart/tree/main/microprofile-reactive-messaging-kafka
5. Use jboss-cli to enable the microprofile reactive messaging and reactive streams operators extensions/subsystems
6. Use jboss-cli to enable the microprofile config extension/subsystem NOTE: THIS IS MISSING FROM THE QUICKSTART WHICH STARTS FROM A DIFFERENT STANDALONE CONFIG
7. Use docker-compose to start kafka/zookeeper
8. Build and deploy the reactive messaging kafka quickstart
Next step is obviously to extend the quickstart code to access the vertx instance and do something interesting.

### Primary

* https://github.com/wildfly/quickstart/tree/main/microprofile-reactive-messaging-kafka
* https://github.com/gaol/wildfly-vertx-extension

### Secondary

* http://www.mastertheboss.com/eclipse/eclipse-microservices/building-reactive-applications-with-wildfly/
* https://www.wildfly.org/news/2021/03/11/WildFly-MicroProfile-Reactive-specifications-feature-pack-2.0/
* https://www.wildfly.org/news/2021/10/14/MicroProfile-Reactive-Messaging-2.0-in-WildFly-25/
* https://smallrye.io/smallrye-mutiny/guides/completion-stages
* https://vertx.io
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/

## Build & run - Vert.x part only

### Auto redeploy starting MainVerticle

```
./redeploy.sh
```

### Exploded classpath starting Vert.x launcher running MainVerticle

```
mvn clean compile dependency:copy-dependencies
CLASSPATH=$(echo target/dependency/*.jar | tr ' ' ':'):target/classes
java -cp $CLASSPATH io.vertx.core.Launcher run io.vertx.starter.MainVerticle
```

## Build & run - Vert.x Microprofile Reactive Messaging Kafka Webapp

### Prepare and start Kafka and Wildfly with Vert.x and Microprofile Reactive Messaging enabled

**Skip to Build & run if Wildfly and Kafka have already been prepared and started**

Shell 1:
```
./1-term1-cycle-basedir.sh
./2-term1-provision-wf.sh
./3-term1-apply-fp-vertx.sh
./4-term1-start-wf.sh
```

Shell 2:
```
./5-term2-enable-mp-reactive.sh
./6-term2-enable-mp-config.sh
./7-term2-start-kafka.sh
```

Shell 3:
```
./8-term3-deploy-app.sh
./9-term3-undeploy-app.sh
```

### Build & run

```
mvn clean package wildfly:deploy
```

## Additional Notes

Requires pre-installed galleon: https://github.com/wildfly/galleon/releases/download/5.0.2.Final/galleon-5.0.2.Final.zip

```
export BASE_DIR_=/tmp/wildfly-reactive-messaging-vertx
```

```
# Must be appropriate for both microprofile reactive messaging kafka quickstart and wildfly vertx extension
# Tested OK with vanilla microprofile reactive messaging kafka quickstart
#export WILDFLY_VERSION_=26.1.1.Final
# Tested OK with both vertx and microprofile reactive messaging quickstart, matches version in vertx extension project
export WILDFLY_VERSION_=26.0.1.Final
```

### [Terminal 1] Set wildfly version and base dir

```
export BASE_DIR=$BASE_DIR_
export WILDFLY_VERSION=$WILDFLY_VERSION_
cd $BASE_DIR
```

### [Terminal 1] Use galleon to provision wildfly, matching version in vertx extension project

```
galleon install wildfly:current#$WILDFLY_VERSION --dir=wildfly-$WILDFLY_VERSION
```

### [Terminal 1] Clone and build wildfly vertx extension project

```
git clone https://github.com/gaol/wildfly-vertx-extension
cd wildfly-vertx-extension
mvn clean install
cd ..
```

### [Terminal 1] Apply vertx extension feature pack to provisioned wildfly

```
galleon install --file=wildfly-vertx-extension/galleon-feature-pack/target/wildfly-vertx-feature-pack-1.0.0-SNAPSHOT.zip --dir=wildfly-$WILDFLY_VERSION
```

### [Terminal 1] Start wildfly with standalone-vertx.xml

```
wildfly-$WILDFLY_VERSION/bin/standalone.sh -c standalone-vertx.xml
```

### [Terminal 2] Set wildfly version and base dir

```
export BASE_DIR=$BASE_DIR_
export WILDFLY_VERSION=$WILDFLY_VERSION_
cd $BASE_DIR
```

### [Terminal 2] Clone microprofile reactive messaging kafka quickstart

```
git clone https://github.com/wildfly/quickstart
```

### [Terminal 2] Enable microprofile reactive messaging and reactive streams operators subsystems

```
wildfly-$WILDFLY_VERSION/bin/jboss-cli.sh --connect --file=quickstart/microprofile-reactive-messaging-kafka/enable-reactive-messaging.cli
```

### [Terminal 2] Enable microprofile config subsystem

```
cat << EOF > quickstart/microprofile-reactive-messaging-kafka/enable-config.cli
batch
/extension=org.wildfly.extension.microprofile.config-smallrye:add
/subsystem=microprofile-config-smallrye:add
run-batch

reload
EOF
wildfly-$WILDFLY_VERSION/bin/jboss-cli.sh --connect --file=quickstart/microprofile-reactive-messaging-kafka/enable-config.cli
```

### [Terminal 2] Start kafka and zookeeper

```
cd quickstart/microprofile-reactive-messaging-kafka
docker-compose up
```

### [Terminal 3] Set wildfly version and base dir

```
export BASE_DIR=$BASE_DIR_
export WILDFLY_VERSION=$WILDFLY_VERSION_
cd $BASE_DIR
```

### [Terminal 3] Build and deploy microprofile reactive messaging kafka quickstart

```
cd quickstart/microprofile-reactive-messaging-kafka
mvn clean package wildfly:deploy
```

### [Terminal 4] Examine quickstart DB actions

```
curl http://localhost:8080/microprofile-reactive-messaging-kafka
```

### Interaction with user initiated code

#### [Terminal 5]

```
curl -N http://localhost:8080/microprofile-reactive-messaging-kafka/user
```

#### [Terminal 6]

```
curl -N http://localhost:8080/microprofile-reactive-messaging-kafka/user
```

#### [Terminal 7]

```
curl -X POST http://localhost:8080/microprofile-reactive-messaging-kafka/user/one
curl -X POST http://localhost:8080/microprofile-reactive-messaging-kafka/user/two
curl -X POST http://localhost:8080/microprofile-reactive-messaging-kafka/user/three
```

### [Terminal 8] Deploy sample war with vertx deployment descriptor

```
git clone https://github.com/gerjantd/vertx-core-manual-examples
cd vertx-core-manual-examples/27
mvn clean wildfly:deploy
```

### Shutdown

```
cd quickstart/microprofile-reactive-messaging-kafka
mvn wildfly:undeploy
mvn clean
docker rm -f microprofile-reactive-messaging-kafka_kafka_1
docker rm -f microprofile-reactive-messaging-kafka_zookeeper_1
```

