package com.andy.apireservations.DTO;

import com.andy.apireservations.validation.CityFormatConstraint;

public class SegmentDTO {

    @CityFormatConstraint
    private String origin;

    @CityFormatConstraint
    private String destination;

    private String departure;
    private String arrival;

    public SegmentDTO(String origin, String destination, String departure, String arrival) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
    }

    // Getters
    // Getters
    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    // Setters
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

}
