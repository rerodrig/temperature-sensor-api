package com.mycompany.temperaturesensor.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class TemperatureMeasurementResponseDto {
    private UUID id;
    private String sensorId;
    private Double temperature;
    private Double latitude;
    private Double longitude;
    private LocalDateTime measurementDateTime;
}
