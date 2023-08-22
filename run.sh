#!/bin/bash

# Compile
./gradlew clean build

# Build image
docker build -t spring-boot-otlp-example:0.0.1-SNAPSHOT .

# Run application
docker run --network="host" -p 8080:8080 spring-boot-otlp-example:0.0.1-SNAPSHOT