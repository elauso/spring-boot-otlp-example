FROM openjdk:17-jdk-slim

EXPOSE 8080

ENV OTEL_TRACES_EXPORTER=otlp

ENV OTEL_METRICS_EXPORTER=otlp

ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://otelcol:4317

ENV OTEL_RESOURCE_ATTRIBUTES=service.name=spring-boot-otlp-example,service.version=0.0.1-SNAPSHOT

WORKDIR /app

COPY opentelemetry/opentelemetry-javaagent.jar build/

ARG JAR=spring-boot-otlp-example-0.0.1-SNAPSHOT.jar

COPY build/libs/$JAR build/app.jar

WORKDIR /app/build

ENTRYPOINT java -javaagent:./opentelemetry-javaagent.jar -jar ./app.jar