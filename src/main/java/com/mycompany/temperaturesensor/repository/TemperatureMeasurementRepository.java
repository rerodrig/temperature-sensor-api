package com.mycompany.temperaturesensor.repository;

import com.mycompany.temperaturesensor.repository.entity.TemperatureMeasurementEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface TemperatureMeasurementRepository extends ReactiveCrudRepository<TemperatureMeasurementEntity, UUID> {

    @Query("{ id: { $exists: true }}")
    Flux<TemperatureMeasurementEntity> findAllByPage(Pageable page);

}
