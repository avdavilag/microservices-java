package com.andy.apireservations.model;

import java.math.BigDecimal;
import java.util.List;

public class Reservation {
    private Long id;
    private List<Passenger>passengers;
    private Itinerary itinerary;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Itinerary getItenary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public static class PriceDTO {
        private BigDecimal totalPrice;
        private BigDecimal totalPax;
        private BigDecimal basePric;

        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
        }

        public BigDecimal getTotalPax() {
            return totalPax;
        }

        public void setTotalPax(BigDecimal totalPax) {
            this.totalPax = totalPax;
        }

        public BigDecimal getBasePric() {
            return basePric;
        }

        public void setBasePric(BigDecimal basePric) {
            this.basePric = basePric;
        }
    }
}
