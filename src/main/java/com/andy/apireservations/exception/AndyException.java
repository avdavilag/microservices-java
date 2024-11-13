package com.andy.apireservations.exception;

public class AndyException extends RuntimeException {
    
    private String description;
    
    public AndyException(String message) {
        super(message);
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
    
    
}
