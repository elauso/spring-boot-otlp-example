#!/bin/bash

# Build application
./gradlew clean build

# Run application (setting otlp java agent)
export OTEL_METRICS_EXPORTER=otlp
export OTEL_TRACES_EXPORTER=none
java -javaagent:./opentelemetry-javaagent.jar -jar ./build/libs/spring-boot-otlp-example-0.0.1-SNAPSHOT.jar
