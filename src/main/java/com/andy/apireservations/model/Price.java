package com.andy.apireservations.model;
import java.math.BigDecimal;

public class Price {
    private BigDecimal totalPrice;
    private BigDecimal totalPax;
    private BigDecimal basePrice;


    public Price() {
    }
    public Price(BigDecimal totalPrice, BigDecimal totalPax, BigDecimal basePrice) {
        this.totalPrice = totalPrice;
        this.totalPax = totalPax;
        this.basePrice = basePrice;
    }

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

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }
}
