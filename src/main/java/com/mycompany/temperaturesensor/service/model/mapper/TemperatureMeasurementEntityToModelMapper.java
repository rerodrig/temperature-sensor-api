package com.mycompany.temperaturesensor.service.model.mapper;

import com.mycompany.temperaturesensor.repository.entity.TemperatureMeasurementEntity;
import com.mycompany.temperaturesensor.service.model.Location;
import com.mycompany.temperaturesensor.service.model.TemperatureMeasurement;

public class TemperatureMeasurementEntityToModelMapper {

    private TemperatureMeasurementEntityToModelMapper() {

    }

    public static TemperatureMeasurement map(TemperatureMeasurementEntity temperatureMeasurementEntity) {
        Location location = new Location(temperatureMeasurementEntity.getLocation()[0],
                temperatureMeasurementEntity.getLocation()[1]);
        return new TemperatureMeasurement(temperatureMeasurementEntity.getId(),
                temperatureMeasurementEntity.getSensorId(),
                temperatureMeasurementEntity.getTemperature(), location,
                temperatureMeasurementEntity.getMeasurementDateTime());
    }
}
