package com.mycompany.temperaturesensor.service.model;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TemperatureMeasurementTest {

    @Test
    public void shouldCreateAlarmingTemperatureMeasurement() {

        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(UUID.randomUUID(), "sensor1", 9.5,
                new Location(-23.6092151541, -46.6671827445), LocalDateTime.of(2019, 4, 6, 9, 53, 0));

        TemperatureRules temperatureRules = new TemperatureRules(10.0, 30.0);

        assertTrue(temperatureMeasurement.isAlarmingTemperature(temperatureRules));

    }

    @Test
    public void shouldCreateNonAlarmingTemperatureMeasurement() {

        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(UUID.randomUUID(), "sensor1", 29.8,
                new Location(-23.6092151541, -46.6671827445), LocalDateTime.of(2019, 4, 6, 9, 53, 0));

        TemperatureRules temperatureRules = new TemperatureRules(10.0, 30.0);

        assertFalse(temperatureMeasurement.isAlarmingTemperature(temperatureRules));

    }
}
