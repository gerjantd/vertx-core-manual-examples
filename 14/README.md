# Module 14

## Description

Vert.x HTTP client examples, as per http://tutorials.jenkov.com/vert.x/http-client.html.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/http-client.html

## Notes

```
$ mvn clean package
$ java -jar target/vertx-starter-14-1.0.0-SNAPSHOT-fat.jar
$ java -cp target/vertx-starter-14-1.0.0-SNAPSHOT-fat.jar io.vertx.starter.VertxApp
$ java -cp target/vertx-starter-14-1.0.0-SNAPSHOT-fat.jar io.vertx.starter.App
```

```
$ ./redeploy.sh
```

```
$ mvn clean compile dependency:copy-dependencies
$ CLASSPATH=target/classes; for j in $(ls target/dependency/); do CLASSPATH=$CLASSPATH:target/dependency/$j; done; echo $CLASSPATH
$ java -cp $CLASSPATH io.vertx.starter.VertxApp
$ java -cp $CLASSPATH io.vertx.starter.App
```

```
$ for i in $(seq 1 4); do curl http://localhost:8080?p=1; echo; done
$ for i in $(seq 1 4); do curl -X POST -d name=daniel -d skill=lousy http://localhost:8080; echo; done
```
