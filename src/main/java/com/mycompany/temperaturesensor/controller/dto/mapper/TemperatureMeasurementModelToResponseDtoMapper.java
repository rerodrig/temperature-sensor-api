package com.mycompany.temperaturesensor.controller.dto.mapper;

import com.mycompany.temperaturesensor.controller.dto.TemperatureMeasurementResponseDto;
import com.mycompany.temperaturesensor.service.model.Location;
import com.mycompany.temperaturesensor.service.model.TemperatureMeasurement;

public class TemperatureMeasurementModelToResponseDtoMapper {

    private TemperatureMeasurementModelToResponseDtoMapper() {

    }

    public static TemperatureMeasurementResponseDto map(TemperatureMeasurement temperatureMeasurement) {
        TemperatureMeasurementResponseDto temperatureMeasurementResponseDto = new TemperatureMeasurementResponseDto();
        temperatureMeasurementResponseDto.setId(temperatureMeasurement.getId());
        temperatureMeasurementResponseDto.setSensorId(temperatureMeasurement.getSensorId());
        temperatureMeasurementResponseDto.setTemperature(temperatureMeasurement.getTemperature());
        Location location = temperatureMeasurement.getLocation();
        temperatureMeasurementResponseDto.setLatitude(location.getLatitude());
        temperatureMeasurementResponseDto.setLongitude(location.getLongitude());
        temperatureMeasurementResponseDto.setMeasurementDateTime(temperatureMeasurement.getMeasurementDateTime());
        return temperatureMeasurementResponseDto;
    }
}
