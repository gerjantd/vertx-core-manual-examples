# Module 23

## Description

Like module 19-22 (timers), using new package structure. Main verticle (pom.xml, redeploy.sh) now: io.vertx.starter.verticle.MainVerticle. No diff between vertx.MainVerticleApp and java.MainVerticleApp.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/

## Build & run

### 1.

```
$ mvn clean package
$ java -jar target/*fat.jar
$ java -cp target/*fat.jar io.vertx.starter.app.vertx.MainVerticleApp
$ java -cp target/*fat.jar io.vertx.starter.app.java.MainVerticleApp
$ java -cp target/*fat.jar io.vertx.starter.app.java.BufferLengthApp
$ java -cp target/*fat.jar io.vertx.starter.app.java.NowLoopApp
$ java -cp target/*fat.jar io.vertx.starter.app.java.HellWorldApp
```

### 2.

```
$ ./redeploy.sh
```

### 3.

```
$ mvn clean compile dependency:copy-dependencies
$ CLASSPATH=$(echo target/dependency/*.jar | tr ' ' ':'):target/classes
$ java -cp $CLASSPATH io.vertx.starter.app.vertx.MainVerticleApp
$ java -cp $CLASSPATH io.vertx.starter.app.java.MainVerticleApp
```

### Test

```
$ vertx -version
$ mvn clean compile dependency:copy-dependencies
$ vertx run io.vertx.starter.verticle.MainVerticle -cp $(echo target/dependency/*.jar|tr ' ' ':'):target/classes
$ mvn clean package
$ vertx run io.vertx.starter.verticle.MainVerticle -cp target/*SNAPSHOT.jar 
$ cd target/classes/
$ vertx run io.vertx.starter.verticle.MainVerticle
```

Broken in Vert.x 4.1.3 (works in 3.9.13):
```
$ cd ../../
$ vertx run src/main/resources/helloworld.js
```
