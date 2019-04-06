package com.mycompany.temperaturesensor.repository;

import com.mycompany.temperaturesensor.repository.entity.TemperatureMeasurementEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TemperatureMeasurementRepository extends ReactiveCrudRepository<TemperatureMeasurementEntity, UUID> {
}
