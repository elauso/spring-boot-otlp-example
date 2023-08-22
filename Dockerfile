FROM openjdk:17-jdk-slim

EXPOSE 8080

ENV OTEL_METRICS_EXPORTER=otlp

ENV OTEL_TRACES_EXPORTER=none

WORKDIR /app

COPY opentelemetry/opentelemetry-javaagent.jar build/

ARG JAR=hello-observability.jar

COPY build/libs/$JAR build/app.jar

WORKDIR /app/build

ENTRYPOINT ["java"," -javaagent:./opentelemetry-javaagent.jar"," -jar ./app.jar"]