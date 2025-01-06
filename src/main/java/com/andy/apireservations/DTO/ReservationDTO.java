package com.andy.apireservations.DTO;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class ReservationDTO {
    private Long id;

    @Valid
    @NotEmpty(message = "You need  at lasted one passager")
    private List<PassengerDTO> passengers;

    @Valid
    private ItineraryDTO itinerary;

    public List<PassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDTO> passengers) {
        this.passengers = passengers;
    }

    public ItineraryDTO getItinerary() {
        return itinerary;
    }

    public void setItinerary(ItineraryDTO itinerary) {
        this.itinerary = itinerary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
