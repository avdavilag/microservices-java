package com.andy.apireservations.DTO;
import  java.util.*;
public class ItenaryDTO {
    private List<SegmentDTO> segments;
     private PriceDTO price;

    public ItenaryDTO(List<SegmentDTO> segments, PriceDTO price) {
        this.segments = segments;
        this.setPrice(price);
    }
    public ItenaryDTO() {}
    public PriceDTO getPrice() {
        return price;
    }

    public void setPrice(PriceDTO price) {
        this.price = price;
    }
}

