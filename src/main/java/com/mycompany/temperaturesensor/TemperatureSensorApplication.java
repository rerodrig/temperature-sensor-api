package com.mycompany.temperaturesensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

@SpringBootApplication
@ImportAutoConfiguration(exclude = MongoAutoConfiguration.class, classes = EmbeddedMongoAutoConfiguration.class)
public class TemperatureSensorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureSensorApplication.class, args);
    }

}
