package com.mycompany.temperaturesensor.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class TemperatureMeasurement {

    private UUID id;
    private String sensorId;
    private Double temperature;
    private Location location;
    private LocalDateTime measurementDateTime;

    public Boolean isAlarmingTemperature(TemperatureRules temperatureRules) {
        return temperature < temperatureRules.getMinAcceptable() || temperature > temperatureRules.getMaxAcceptable();
    }
}
