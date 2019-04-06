package com.mycompany.temperaturesensor.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The rules can be provided by external configuration for more flexibility.
 */
@AllArgsConstructor
@Getter
public class TemperatureRules {
    private Double minAcceptable;
    private Double maxAcceptable;
}
