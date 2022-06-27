# Module 27

## Description

Like module 26, exercising deployment descriptor.

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

Shell 2:
```
$ mvn clean wildfly:deploy
$ ab -c 4 -n 8 http://127.0.0.1:8888/
```
