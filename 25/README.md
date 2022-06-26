# Module 25

## Description

Like module 24, adding eventbus verticles.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/

## Build & run

### Auto redeploy starting MainVerticle

```
$ ./redeploy.sh
```

### Fat jar starting MainVerticle

```
$ mvn clean package
$ java -jar target/*fat.jar
```

### Fat jar as classpath starting App

```
$ mvn clean package
$ java -cp target/*fat.jar io.vertx.starter.App
```

### Exploded classpath starting App

```
$ mvn clean compile dependency:copy-dependencies
$ CLASSPATH=$(echo target/dependency/*.jar | tr ' ' ':'):target/classes
$ java -cp $CLASSPATH io.vertx.starter.App
```
