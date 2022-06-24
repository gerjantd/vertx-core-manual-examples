#!/bin/sh

run03 () {
  clear
  pushd $MODULE > /dev/null 2>&1
  head -n 5 README
  echo "\n========\n"
  mvn clean compile
  echo ""
  head -n 5 README
  echo "\n========\n"
  java -cp target/classes App
  popd > /dev/null 2>&1
}

run04 () {
  clear
  pushd $MODULE > /dev/null 2>&1
  head -n 5 README
  echo "\n========\n"
  mvn clean package
  echo ""
  head -n 5 README
  echo "\n========\n"
  java -cp target/vertx*fat.jar App
  popd > /dev/null 2>&1
}

run05 () {
  clear
  pushd $MODULE > /dev/null 2>&1
  head -n 5 README
  echo "\n========\n"
  mvn clean package
  echo ""
  head -n 5 README
  echo "\n========\n"
  java -cp target/vertx*fat.jar VertxApp
  popd > /dev/null 2>&1
}

run06 () {
  clear
  pushd $MODULE > /dev/null 2>&1
  head -n 5 README
  echo "\n========\n"
  mvn clean package
  echo ""
  head -n 5 README
  echo "\n========\n"
  java -cp target/vertx*fat.jar io.vertx.starter.VertxApp
  popd > /dev/null 2>&1
}

run10 () {
  clear
  pushd $MODULE > /dev/null 2>&1
  head -n 5 README
  echo "\n========\n"
  mvn clean package
  echo ""
  head -n 5 README
  echo "\n========\n"
  java -jar target/vertx*fat.jar
  popd > /dev/null 2>&1
}

#for MODULE in $(seq -f "%02g" 0 4); do run05; done
for MODULE in $(seq -f "%02g" 3 3); do run03; done
for MODULE in $(seq -f "%02g" 4 4); do run04; done
exit 0
for MODULE in $(seq -f "%02g" 5 5); do run05; done
for MODULE in $(seq -f "%02g" 6 9); do run06; done
for MODULE in $(seq -f "%02g" 10 20); do run10; done
