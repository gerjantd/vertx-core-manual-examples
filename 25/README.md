# Module 25

## Description

Like module 24, showing sync and async deployment alternatives as in module 07.

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
