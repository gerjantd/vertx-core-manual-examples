# Vert.x starters

## Description

Maven Vert.x starter parent project, with modules showing basic development cases.

## Requirements

* Java 11
* Maven 3.8 

## Current stack

* Vert.x 4.3
* JUnit 5

## References

* https://sdkman.io/
* https://vertx.io/docs/vertx-core/java/
* https://github.com/vert-x3/vertx-maven-starter
* http://tutorials.jenkov.com/vert.x/verticles.html

## Notes

### Build and run all modules

```bash
$ ./smoke-test.sh -v -f 0 -t $(find . -maxdepth 1 -type d -name "??" | sed -e 's/.\///' | sort -r | head -n 1)
```

### New module workflow

#### All, part 0.

$ export OLD=21
$ export NEW=22
$ git status
$ mvn clean
$ git branch -a
$ git checkout -b $NEW
$ cp -pvri $OLD $NEW

#### Macos, part 1.

$ sed -i "" -e "s/^  <\/modules>/    <module>$NEW<\/module>\n  <\/modules>/" pom.xml
$ sed -i "" -e "s/vertx-starter-[0-9]\{2\}/vertx-starter-$NEW/" $NEW/pom.xml
$ sed -i "" -e "s/Module $OLD/Module $NEW/" $NEW/README

#### Linux, part 1.

$ sed -i -e 's/^  <\/modules>/    <module>$NEW<\/module>\n  <\/modules>/' pom.xml
$ sed -i -e 's/vertx-starter-[0-9]\{2\}/vertx-starter-$NEW/' $NEW/pom.xml
$ sed -i -e 's/Module $OLD/Module $NEW/' $NEW/README

#### All, part 2.

$ less pom.xml 
$ less $NEW/pom.xml 
$ less $NEW/README 
$ cd $NEW

(work)*

$ ./redeploy.sh 
$ mvn clean package
$ java -jar target/*fat.jar 
$ cd ..
$ git status
$ git add pom.xml $NEW
$ git commit -m "Add module $NEW (DESCRIPTION)"
$ mvn clean
$ git checkout master
$ git merge $NEW
$ git log
$ git tag -a $NEW-DESCRIPTION -m "DESCRIPTION"
$ git push origin master --tags
$ git branch -d $NEW

