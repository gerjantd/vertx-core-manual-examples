# Module 24

## Description

Based off Vert.x 4.1.3 starter, reverted to simple package structure, cleaned up, using 3 verticles: http-server (MainVerticle), once, and periodic timer.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/

## Build & run

### Auto redeploy starting only MainVerticle

```
$ ./redeploy.sh
```

### Fat jar starting only MainVerticle

```
$ mvn clean package
$ java -jar target/*fat.jar
```

### Fat jar as classpath starting App deploying all verticles

```
$ mvn clean package
$ java -cp target/*fat.jar io.vertx.starter.App
```

### Exploded classpath starting App deploying all verticles

```
$ mvn clean compile dependency:copy-dependencies
$ CLASSPATH=$(echo target/dependency/*.jar | tr ' ' ':'):target/classes
$ java -cp $CLASSPATH io.vertx.starter.App
```
