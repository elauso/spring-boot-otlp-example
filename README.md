# Spring Boot Open Telemetry Example

Aplicação que exporta métricas e traces para o Prometheus e Jaeger, usando o Open-Telemetry.

## Sobre o Open-Telemetry

O Open-Telemetry é um conjunto de ferramentas usados para provê observabilidade da sua aplicação.

É uma solução open-source, que surgiu com a fusão dos projetos Open-Census e Open-Tracing.

É vendor-neutral, pois permite habilitar a observabilidade, usando coletores que exportam as métricas para diversas soluções como Prometheus, Jaeger (etc), sem ficar preso a uma solução específica.

![Alt text](./open-telemetry-collector.png?raw=true "Exemplo solução com open-telemetry")

Imagem: https://www.giorgosdimtsas.net/blog/collecting-spring-boot-telemetry-data-with-opentelemetry/

Nesse projeto é usado o Open-Telemetry para coletar as métricas da aplicação, e exportá-las para os backends Prometheus e Jaeger. Ao final será exibida as métricas em um gráfico gerado no Grafana.

## Stack

Tecnologia                       |  Versão       |
---------------------------------|---------------|
jdk                              | 17
spring-boot                      | 3.1.2
map-struct                       | 1.5.5.Final
lombok                           | 1.18.20
lombok-mapstruct-binding         | 0.2.0
mysql-connector-java             | 8.0.33

## Dependências

* jdk17
* docker
* docker-compose

## Instalação

Execute o script: ```./run.sh```

## Execução

Execute o comando para registar um novo produto:

```curl -i -H "Content-Type: application/json" http://localhost:8080/products -d '{"name":"test01","type":"CONVENIENCE"}'```

Para consultar o produto registrado:

```curl -i http://localhost:8080/products/1```

Para consultar as métricas registradas:

http://localhost:8889/metrics

Para visualizar os traces das chamadas:

http://localhost:16686/

Para visualizar as métricas no dashboard do Grafana:

1. Acesse a interface web pelo link: http://localhost:3000
2. Faça o login usando as credenciais default (admin/admin)
3. Importe o datasource do Prometheus: Menu > Data sources > Add data source > Prometheus > Preencha URL=http://prometheus:9090 > Save & Test
4. Importe o dashboard: Menu > Dashboards > New Import > Upload dashboard JSON > springboot_apm_dashboard_1693804356811.json > Import