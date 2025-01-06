package com.andy.apireservations.DTO;

import java.util.List;

import jakarta.validation.Valid;

public class ItineraryDTO {

    @Valid
    private List<SegmentDTO> segment;

    private PriceDTO price;

    public List<SegmentDTO> getSegment() {
        return segment;
    }

    public void setSegment(List<SegmentDTO> segment) {
        this.segment = segment;
    }

    public PriceDTO getPrice() {
        return price;
    }

    public void setPrice(PriceDTO price) {
        this.price = price;
    }
}
