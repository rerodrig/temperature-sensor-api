# Temperature Sensor API
## Prerequisites
```
Java 1.8 (jdk)
Docker
Docker Compose
```
### Build project
```sh
/temperature-sensor-api$ ./gradlew clean build
```

### Run locally

#### Embedded Database
Run the project.
```sh
/temperature-sensor-api$ ./gradlew bootRun
```

#### External Database
Remove MongoDB embedded auto configuration from Spring Boot in TemperatureSensorApplication class.
```java
@ImportAutoConfiguration(exclude = MongoAutoConfiguration.class, classes = EmbeddedMongoAutoConfiguration.class)
```
Start MongoDB docker container.
```sh
/temperature-sensor-api/local$ ./start.sh
```
Run the project.
```sh
/temperature-sensor-api$ ./gradlew bootRun
```
 ### Swagger Docs
 http://localhost:8080/swagger-ui.html