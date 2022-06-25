# Module 03

## Description

Like module 02 (Maven Java Hello World), using parent pom and specifying packaging jar.

## Notes

```
$ mvn clean compile
$ java -cp target/classes App
```

```
$ mvn clean package
$ java -cp target/*fat.jar App
```

```
$ mvn clean package
$ java -cp target/*SNAPSHOT.jar App
```
