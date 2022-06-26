# Module 11

## Description

Vert.x buffers examples, as per http://tutorials.jenkov.com/vert.x/buffers.html.

## References

* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/buffers.html

## Notes

```
$ mvn clean package
$ java -jar target/*fat.jar
$ java -cp target/*fat.jar io.vertx.starter.VertxApp
$ java -cp target/*fat.jar io.vertx.starter.App
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
