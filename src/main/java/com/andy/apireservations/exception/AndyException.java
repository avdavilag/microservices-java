package com.andy.apireservations.exception;

import org.springframework.http.HttpStatus;

import com.andy.apireservations.enums.APIError;

import java.util.*;

public class AndyException extends RuntimeException {

    // private String description;

    // public AndyException(String message) {
    // super(message);
    // }

    // public String getDescription() {return description;}

    // public void setDescription(String description) {this.description =
    // description;}

    private HttpStatus status;

    private String description;

    private List<String> reasons;

    public AndyException(APIError error) {
        this.status = error.getHttpStatus();
        this.description = error.getMessage();
    }

    public AndyException(String message, HttpStatus status, String description, List<String> reasons) {
        super(message);
        this.status = status;
        this.description = description;
        this.reasons = reasons;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getReasons() {
        return reasons;
    }

    public void setReasons(List<String> reasons) {
        this.reasons = reasons;
    }
}
