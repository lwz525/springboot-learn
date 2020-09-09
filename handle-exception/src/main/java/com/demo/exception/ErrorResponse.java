package com.demo.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ErrorResponse {
    private String message;
    private String errorTypeName;

    public ErrorResponse(){}

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(),e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }
}
