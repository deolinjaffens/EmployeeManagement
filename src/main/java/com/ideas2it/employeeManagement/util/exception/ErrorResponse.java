package com.ideas2it.employeeManagement.util.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String errorMessage;
    private int errorCode;
    Map<String,String> errors;

    public ErrorResponse(int errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ErrorResponse(int errorCode, Map<String,String> errors) {
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
