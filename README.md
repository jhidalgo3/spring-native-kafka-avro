# spring-native-kafka-avro

```
sdk use java 22.0.0.2.r17-grl 

mvn clean package -P default,spring-native,build-native-image
```

__Run spring-boot application__

```
 mvn spring-boot:run -Dspring-boot.run.profiles=confluent-cloud -P default,spring-native
```

## Build docker Native Image

```
mvn clean package -P default,spring-native,build-docker-image
```

## Build docker Image

```
mvn clean package -P default,spring-native
docker build -t jhidalgo3/spring-kafka-avro --rm --build-arg JAR=target/spring-native-kafka-avro-0.0.1-SNAPSHOT.jar .
```

**Specific configuration dir**

SPRING_CONFIG_NAME=application
SPRING_CONFIG_LOCATION=file:///config/
SPRING_PROFILES_ACTIVE=docker

docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker -e SPRING_CONFIG_LOCATION=file:///config/  -ti -v $PWD/src/main/resources/:/config jhidalgo3/spring-native-kafka-avro:latest

**Confluent-cloud**

```
 docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=confluent-cloud -e SPRING_CONFIG_LOCATION=file:///config/  -ti -v $PWD/config/:/config docker.io/jhidalgo3/spring-kafka-avro:latest
```

 **helm installation**

Native

```
helm upgrade --install -f values-producer-native.yml spring-native-kafka-avro --set prometheus.enabled=true ./helm-chart
```

Normal

```
helm upgrade --install -f values-producer.yml spring-kafka-avro ./helm-chart
```