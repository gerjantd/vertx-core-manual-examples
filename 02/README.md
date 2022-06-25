# Module 02

## Description

Java Hello World project created using Apache Maven archetype plugin (note: does not use parent pom).

## Notes

```
$ mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.3
```

```
$ mvn clean compile
$ java -cp target/classes jar.App
```

```
$ mvn clean package
$ java -cp target/*.jar jar.App
```
