#!/bin/sh

# Define functions

show_help() {
  echo "Usage: $(basename $0) -f FROM_MODULE:${FROM_MODULE} [-t TO_MODULE:${TO_MODULE}]" >&2
  echo "Example: $(basename $0) -f 9 -t 11" >&2
}

build_and_run () {
  clear
  pushd $(printf "%02d\n" $MODULE) > /dev/null 2>&1
  head -n 5 README
  echo "\n========\n"
  echo "Building...\n"
  eval "$BUILD_COMMAND"
  echo ""
  head -n 5 README
  echo "\n========\n"
  echo "Running... (Press Ctrl+C to continue)\n"
  eval "$RUN_COMMAND"
  popd > /dev/null 2>&1
}

show_time() {
  echo "\n========\n"
  ENDED=$(date +%s)
  echo "Ran $(basename $0 .sh) on modules $(printf "%02d\n" $FROM_MODULE) to $(printf "%02d\n" $TO_MODULE) in $(( (ENDED - STARTED) )) seconds"
}

# https://stackoverflow.com/questions/192249/how-do-i-parse-command-line-arguments-in-bash
# Reset POSIX variable OPTIND in case getopts has been used previously in the shell
OPTIND=1

# Initialize variables
OUTPUT_FILE="$(basename $0 .sh).out"
VERBOSE=0
FROM_MODULE=
TO_MODULE=0
STARTED=$(date +%s)
ENDED=

while getopts "h?vo:f:t:" OPT; do
  case "$OPT" in
  h|\?)
    show_help
    exit 0
    ;;
  v)  VERBOSE=1
    ;;
  o)  OUTPUT_FILE=$OPTARG
    ;;
  f)  FROM_MODULE=$OPTARG
    ;;
  t)  TO_MODULE=$OPTARG
    ;;
  esac
done

shift $((OPTIND-1))

[ "${1:-}" = "--" ] && shift

echo "VERBOSE=$VERBOSE, OUTPUT_FILE="$OUTPUT_FILE", FROM_MODULE=$FROM_MODULE, TO_MODULE=$TO_MODULE, Leftovers: $@"

if [ "${FROM_MODULE}" = "" ]; then
  show_help
  exit 0
fi

if [ $FROM_MODULE -gt $TO_MODULE ]; then
  TO_MODULE=$FROM_MODULE
fi

for MODULE in $(seq $FROM_MODULE $TO_MODULE); do
# https://unix.stackexchange.com/questions/49861/seq-invalid-floating-point-argument-error
#printf '<%q>\n' "$FROM_MODULE"
#printf '<%q>\n' "$TO_MODULE"
  BUILD_COMMAND="mvn clean package"
  if [ $MODULE -eq 0 ]; then
    echo "Module $MODULE is broken"
    exit 0
  elif [ $MODULE -eq 1 ]; then
    RUN_COMMAND="java -jar target/*fat.jar"
  elif [ $MODULE -eq 2 ]; then
    RUN_COMMAND="java -cp target/*.jar jar.App"
  elif [ $MODULE -eq 3 ]; then
    RUN_COMMAND="java -cp target/*SNAPSHOT.jar App"
  elif [ $MODULE -eq 4 ]; then
    RUN_COMMAND="java -cp target/*fat.jar App"
  elif [ $MODULE -eq 5 ]; then
    RUN_COMMAND="java -cp target/*fat.jar VertxApp"
  elif [ $MODULE -ge 6 ] && [ $MODULE -le 9 ]; then
    RUN_COMMAND="java -cp target/*fat.jar io.vertx.starter.VertxApp"
  elif [ $MODULE -ge 10 ]  && [ $MODULE -le 20 ]; then
    RUN_COMMAND="java -jar target/*fat.jar"
  else
    echo "Module $MODULE does not exist"
    exit 0
  fi
  build_and_run
done

ENDED=$(date)
show_time

