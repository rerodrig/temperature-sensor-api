package com.mycompany.temperaturesensor.controller;

import com.mycompany.temperaturesensor.controller.dto.TemperatureMeasurementRequestDto;
import com.mycompany.temperaturesensor.controller.dto.TemperatureMeasurementResponseDto;
import com.mycompany.temperaturesensor.controller.dto.mapper.TemperatureMeasurementModelToResponseDtoMapper;
import com.mycompany.temperaturesensor.controller.dto.mapper.TemperatureMeasurementRequestDtoToModelMapper;
import com.mycompany.temperaturesensor.service.TemperatureMeasurementService;
import com.mycompany.temperaturesensor.service.model.TemperatureMeasurement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/v1/temperature-measurements")
@Api(value = "Temperature Measurement", tags = "V1-Temperature-Measurement")
public class TemperatureMeasurementController {

    private final TemperatureMeasurementService temperatureMeasurementService;

    @Autowired
    public TemperatureMeasurementController(TemperatureMeasurementService temperatureMeasurementService) {
        this.temperatureMeasurementService = temperatureMeasurementService;
    }

    @GetMapping
    @ApiOperation(value = "List all temperature measurements",
                  response = TemperatureMeasurementResponseDto.class,
                  responseContainer = "List")
    public Flux<TemperatureMeasurementResponseDto> listTemperatureMeasurements() {
        Flux<TemperatureMeasurement> temperatureMeasurementFlux = temperatureMeasurementService.list();
        return temperatureMeasurementFlux.map(TemperatureMeasurementModelToResponseDtoMapper::map);
    }

    @PostMapping
    @ApiOperation(value = "Save temperature measurement")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Temperature measurement created") })
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UUID> addTemperatureMeasurement(
            @ApiParam(value = "Temperature measurement")
            @RequestBody @Valid TemperatureMeasurementRequestDto temperatureMeasurementRequestDto,
            @ApiIgnore final ServerHttpRequest serverHttpRequest,
            @ApiIgnore final ServerHttpResponse serverHttpResponse) {

        TemperatureMeasurement temperatureMeasurement = TemperatureMeasurementRequestDtoToModelMapper.map(
                temperatureMeasurementRequestDto);

        Mono<UUID> monoId = temperatureMeasurementService.save(temperatureMeasurement);

        monoId.subscribe(id -> serverHttpResponse.getHeaders()
                .add("Location", String.format("%s/%s", serverHttpRequest.getURI().toString(), id)));

        return monoId;

    }

}
