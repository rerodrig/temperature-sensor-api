package com.mycompany.temperaturesensor.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "measurements")
public class TemperatureMeasurementEntity {
    @Id
    private UUID id;
    private String sensorId;
    private Double temperature;
    @GeoSpatialIndexed
    private Double[] location;
    private LocalDateTime measurementDateTime;
}
