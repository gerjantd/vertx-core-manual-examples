# Module 23

## Description

Like module 20 and 21 (command line Vert.x), verifying simplified new module workflow.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/command-line.html

## Build & run

### 1.

```
$ mvn clean package
$ java -jar target/*fat.jar
($ java -cp target/*fat.jar io.vertx.starter.VertxApp)
($ java -cp target/*fat.jar io.vertx.starter.JavaAppMainVerticle)
```

### 2.

```
$ ./redeploy.sh
```

### 3.

```
$ mvn clean compile dependency:copy-dependencies
$ CLASSPATH=$(echo target/dependency/*.jar | tr ' ' ':'):target/classes
$ java -cp $CLASSPATH io.vertx.starter.VertxApp
($ java -cp $CLASSPATH io.vertx.starter.JavaAppMainVerticle)
```

### Test

```
$ vertx -version
$ mvn clean compile dependency:copy-dependencies
$ vertx run io.vertx.starter.MainVerticle -cp $(echo target/dependency/*.jar|tr ' ' ':'):target/classes
$ mvn clean package
$ vertx run io.vertx.starter.MainVerticle -cp target/*SNAPSHOT.jar 
$ cd target/classes/
$ vertx run io.vertx.starter.MainVerticle
$ cd ../../
$ vertx run src/main/resources/helloworld.js
```
