package com.mycompany.temperaturesensor.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Getter
@Setter
public class TemperatureMeasurementRequestDto {
    @NotNull
    private String sensorId;
    @NotNull
    private Double temperature;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotNull
    private LocalDateTime measurementDateTime;
}
