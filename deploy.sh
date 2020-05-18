#! /bin/sh
mvn clean install -DskipTests
cp ./target/pg-rbc-assignment.jar ./bin/

