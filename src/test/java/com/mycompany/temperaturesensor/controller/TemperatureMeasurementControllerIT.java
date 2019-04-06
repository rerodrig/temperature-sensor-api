package com.mycompany.temperaturesensor.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class TemperatureMeasurementControllerIT extends AbstractControllerIT {

    private static final String TEMPERATURE_MEASUREMENTS_PATH = "/v1/temperature-measurements";

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldCreateTemperatureMeasurement() {

        String temperatureMeasurementJson = createTemperatureMeasurement();

        AtomicReference<UUID> atomicId = new AtomicReference<>();

        WebTestClient.ResponseSpec created = webClient.post()
                .uri(TEMPERATURE_MEASUREMENTS_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(temperatureMeasurementJson), String.class)
                .exchange()
                .expectStatus()
                .isCreated().expectHeader().value("Location", location -> {
                    String id = location.substring(location.lastIndexOf("/") + 1);
                    atomicId.set(UUID.fromString(id));
                });

        String sensorIdJsonPath = String.format("$[?(@.id == '%s')].sensorId", atomicId.get());

        webClient.get()
                .uri(TEMPERATURE_MEASUREMENTS_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody().jsonPath(sensorIdJsonPath).isEqualTo("sensor1");
    }

    private String createTemperatureMeasurement() {
        return "{\n" +
                "\"sensorId\": \"sensor1\",\n" +
                "\"temperature\": \"10.52\",\n" +
                "\"latitude\": \"-23.6092151541\",\n" +
                "\"longitude\": \"-46.6671827445\",\n" +
                "\"measurementDateTime\": \"2018-04-05T21:10:00\"\n" +
                "}";
    }

}
