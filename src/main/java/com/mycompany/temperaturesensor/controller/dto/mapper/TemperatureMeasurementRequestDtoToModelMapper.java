package com.mycompany.temperaturesensor.controller.dto.mapper;

import com.mycompany.temperaturesensor.controller.dto.TemperatureMeasurementRequestDto;
import com.mycompany.temperaturesensor.service.model.Location;
import com.mycompany.temperaturesensor.service.model.TemperatureMeasurement;

public class TemperatureMeasurementRequestDtoToModelMapper {

    private TemperatureMeasurementRequestDtoToModelMapper() {

    }

    public static TemperatureMeasurement map(TemperatureMeasurementRequestDto temperatureMeasurementRequestDto) {
        Location location = new Location(temperatureMeasurementRequestDto.getLatitude(),
                temperatureMeasurementRequestDto.getLongitude());

        return new TemperatureMeasurement(null, temperatureMeasurementRequestDto.getSensorId(),
                temperatureMeasurementRequestDto.getTemperature(), location,
                temperatureMeasurementRequestDto.getMeasurementDateTime());
    }
}
