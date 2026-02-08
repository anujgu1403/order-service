
# Cart Service - Enterprise Skeleton

This is an enterprise-ready skeleton for a Cart microservice built with Spring Boot (Java 21).

## Run locally (H2)
Set datasource in application.properties to use H2 for tests or PostgreSQL for production.

## Build
./gradlew build

## Run
./gradlew bootRun

## Open swagger
http://localhost:8086/v3/api-docs
http://localhost:8086/swagger-ui/index.html

To run kafka locally
a. Generate the clusterid
bin/kafka-storage.sh random-uuid

b. Format storage
bin/kafka-storage.sh format \
-t uP9xYzK4Qx2H2GqABC123 \
-c config/kraft/server.properties

c. Start kafka
bin/kafka-server-start.sh config/kraft/server.properties

d. Create Kafka topic
bin/kafka-topics.sh \
--create \
--bootstrap-server localhost:9092 \
--topic order.capture \
--partitions 3 \
--replication-factor 1

e. to see message/consume from kafka topic
bin/kafka-console-consumer.sh \
--topic order.capture \
--from-beginning \
--bootstrap-server localhost:9092

f. to check message in kafka topic without consuming
bin/kafka-get-offsets.sh \
--bootstrap-server localhost:9092 \
--topic order.capture
