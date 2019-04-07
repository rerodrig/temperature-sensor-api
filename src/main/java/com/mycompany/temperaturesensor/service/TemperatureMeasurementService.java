package com.mycompany.temperaturesensor.service;

import com.mycompany.temperaturesensor.repository.TemperatureMeasurementRepository;
import com.mycompany.temperaturesensor.repository.entity.TemperatureMeasurementEntity;
import com.mycompany.temperaturesensor.service.model.TemperatureMeasurement;
import com.mycompany.temperaturesensor.service.model.mapper.TemperatureMeasurementEntityToModelMapper;
import com.mycompany.temperaturesensor.service.model.mapper.TemperatureMeasurementModelToEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
public class TemperatureMeasurementService {

    private final TemperatureMeasurementRepository repository;

    @Autowired
    public TemperatureMeasurementService(TemperatureMeasurementRepository repository) {
        this.repository = repository;
    }

    public Mono<UUID> save(TemperatureMeasurement temperatureMeasurement) {

        TemperatureMeasurementEntity temperatureMeasurementEntity = TemperatureMeasurementModelToEntityMapper.map(
                temperatureMeasurement);

        Mono<TemperatureMeasurementEntity> mono = repository.save(temperatureMeasurementEntity);

        mono.subscribe(savedEntity -> log.info("Temperature measurement saved with id {}", savedEntity.getId()),
                error -> log.error("Error saving temperature measurement", error));

        return mono.map(TemperatureMeasurementEntity::getId);

    }

    public Flux<TemperatureMeasurement> list(Integer pageNumber, Integer pageSize) {

        Flux<TemperatureMeasurementEntity> measurementEntityFlux = repository.findAllByPage(
                PageRequest.of(--pageNumber, pageSize, Sort.Direction.DESC, "measurementDateTime"));

        return measurementEntityFlux.map(TemperatureMeasurementEntityToModelMapper::map);

    }
}
