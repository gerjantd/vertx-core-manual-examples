# Module 19

## Description

Vert.x timers examples, as per http://tutorials.jenkov.com/vert.x/timers.html.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/timers.html

## Build & run

### 1.

```
$ mvn clean package
$ java -jar target/vertx-starter-19-1.0.0-SNAPSHOT-fat.jar
($ java -cp target/vertx-starter-19-1.0.0-SNAPSHOT-fat.jar io.vertx.starter.VertxApp)
($ java -cp target/vertx-starter-19-1.0.0-SNAPSHOT-fat.jar io.vertx.starter.JavaAppMainVerticle)
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
