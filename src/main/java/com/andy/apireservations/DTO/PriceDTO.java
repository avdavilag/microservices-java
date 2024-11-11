package com.andy.apireservations.DTO;
import java.math.BigDecimal;
public class PriceDTO {
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
