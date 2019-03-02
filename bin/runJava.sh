clear

echo "Compiling Tester.java"

javac Tester.java || exit 1

echo "Running Tester"

java Tester || exit 1

echo "Done runnin', bye!"