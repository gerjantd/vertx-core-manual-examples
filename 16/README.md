# Module 16

## Description

Vert.x TCP server examples, as per http://tutorials.jenkov.com/vert.x/tcp-server.html.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/tcp-server.html

## Build & run

### 1.

```
$ mvn clean package
$ java -jar target/vertx-starter-16-1.0.0-SNAPSHOT-fat.jar
($ java -cp target/vertx-starter-16-1.0.0-SNAPSHOT-fat.jar io.vertx.starter.VertxApp)
($ java -cp target/vertx-starter-16-1.0.0-SNAPSHOT-fat.jar io.vertx.starter.JavaAppMainVerticle)
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
$ nc localhost 10000
dajfdjflkaj
response...alkfjlkdjfla
response...ajfdfjlkjf
response...^C
#for i in $(seq 1 4); do curl http://localhost:8080?p=$i; echo; done
#for i in $(seq 1 4); do curl -X POST -d name=daniel -d skill=lousy http://localhost:8080; echo; done
```
