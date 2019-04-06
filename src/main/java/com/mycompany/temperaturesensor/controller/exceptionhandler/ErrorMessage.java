package com.mycompany.temperaturesensor.controller.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private int statusCode;

    private long timestamp;

    private String message;

    private List<String> errors;

    public ErrorMessage(int status, long timestamp, String message, List<String> errors) {
        this.statusCode = status;
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }
}

