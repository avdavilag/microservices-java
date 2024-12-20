package com.andy.apireservations.model;

import java.util.List;
public class Itinerary {
    private Long id;
    private List<Segment> Segment;
     private Price price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<com.andy.apireservations.model.Segment> getSegment() {
        return Segment;
    }

    public void setSegment(List<com.andy.apireservations.model.Segment> segment) {
        Segment = segment;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}

