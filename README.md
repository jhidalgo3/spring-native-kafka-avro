# spring-native-kafka-avro


sdk use java 22.0.0.2.r17-grl 

mvn clean package -P default,spring-native,build-native-image


__Run spring-boot application__

 mvn spring-boot:run -Dspring-boot.run.profiles=confluent-cloud -P default,spring-native


## Build docker Image

mvn clean package -P default,spring-native,build-docker-image

**Specific configuration dir**

SPRING_CONFIG_NAME=application
SPRING_CONFIG_LOCATION=file:///config/
SPRING_PROFILES_ACTIVE=docker

docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker -e SPRING_CONFIG_LOCATION=file:///config/  -ti -v $PWD/src/main/resources/:/config docker.io/jhidalgo3/spring-native-kafka-avro:latest

**Confluent-cloud**

 docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=confluent-cloud -e SPRING_CONFIG_LOCATION=file:///config/  -ti -v $PWD/config/:/config docker.io/jhidalgo3/spring-native-kafka-avro:latest