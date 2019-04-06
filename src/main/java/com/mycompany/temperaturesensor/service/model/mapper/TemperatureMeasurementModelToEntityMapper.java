package com.mycompany.temperaturesensor.service.model.mapper;

import com.mycompany.temperaturesensor.repository.entity.TemperatureMeasurementEntity;
import com.mycompany.temperaturesensor.service.model.TemperatureMeasurement;

import java.util.UUID;

public class TemperatureMeasurementModelToEntityMapper {

    private TemperatureMeasurementModelToEntityMapper() {

    }

    public static TemperatureMeasurementEntity map(TemperatureMeasurement temperatureMeasurement) {

        Double[] location = new Double[] { temperatureMeasurement.getLocation().getLatitude(),
                temperatureMeasurement.getLocation().getLongitude() };

        return new TemperatureMeasurementEntity(UUID.randomUUID(), temperatureMeasurement.getSensorId(),
                temperatureMeasurement.getTemperature(), location,
                temperatureMeasurement.getMeasurementDateTime());
    }
}
