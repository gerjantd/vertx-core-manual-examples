# Module 24

## Description

Like module 23 (timers), cleaned up. 

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
```
