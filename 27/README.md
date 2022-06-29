# Module 27

## Description

Like module 26, exercising deployment descriptor, and deploying to local or remote wildfly.

## Notes

Module 26 used a deployment descripter that deploys only MainVerticle. This verticle subsequently deploys PeriodicTimerVerticle synchronously, and then OnceTimerVerticle and HttpServerVerticle asynchronously, clarifying various events.

Module 27 uses a deployment descriptor deploying both TimerVerticles and HttpServerVerticle. All of these are deployed synchronously.

However, the start method of HttpServerVerticle starts the HTTP server itself asynchronously. Revies the source code and the logged events.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/
* https://gaol.github.io/wildfly-vertx-extension/

## Build & run

### Auto redeploy starting MainVerticle

```
$ ./redeploy.sh
```

### Exploded classpath starting Vert.x launcher running MainVerticle

```
$ mvn clean compile dependency:copy-dependencies
$ CLASSPATH=$(echo target/dependency/*.jar | tr ' ' ':'):target/classes
$ java -cp $CLASSPATH io.vertx.core.Launcher run io.vertx.starter.MainVerticle
```

### War deploy in Wildfly with Vert.x extension starting MainVerticle

Shell 1:
```
$ git clone https://github.com/gaol/wildfly-vertx-extension
$ cd wildfly-vertx-extension
$ mvn clean install
$ cd dist/target/wildfly-vertx-dist*
$ bin/standalone -c standalone-vertx.xml
```

#### Local Wildfly

Shell 2:
```
$ mvn clean wildfly:deploy
$ ab -c 4 -n 8 http://127.0.0.1:8888/
```

#### Remote  Wildfly

Shell 2:
```
$ mvn clean wildfly:deploy -Pwildfly-remote
$ ab -c 4 -n 8 http://192.168.0.15:8888/
```

## Provision galleon feature pack

### Use galleon to provision wildfly 26.0 (matching wildfly version in vertx extension project)

```
wget https://github.com/wildfly/galleon/releases/download/5.0.2.Final/galleon-5.0.2.Final.zip
unzip galleon-5.0.2.Final.zip
galleon-5.0.2.Final/bin/galleon.sh install wildfly:current#26.0.1.Final --dir=~/wildfly-26.0-galleon-provisioned
```

### Build the wildfly vertx extension (includes galleon feature pack)

```
git clone https://github.com/gaol/wildfly-vertx-extension
cd wildfly-vertx-extension
mvn clean install
```

### Use galleon to apply vertx extension feature pack to provisioned wildfly

```
cd ..
galleon-5.0.2.Final/bin/galleon.sh install --file=~/wildfly-vertx-extension/galleon-feature-pack/target/wildfly-vertx-feature-pack-1.0.0-SNAPSHOT.zip --dir=~/wildfly-26.0-galleon-provisioned
```

### Start wildfly

```
wildfly-26.0-galleon-provisioned/bin/standalone.sh -c standalone-vertx.xml &
```

### Deploy sample war with vertx deployment descriptor

```
git clone https://github.com/gerjantd/vertx-core-manual-examples
cd vertx-core-manual-examples/27
mvn clean wildfly:deploy
```
