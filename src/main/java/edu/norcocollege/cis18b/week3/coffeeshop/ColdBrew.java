package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class ColdBrew extends Beverage {

    private static final BigDecimal BASE_PRICE = new BigDecimal("4.00");

    public ColdBrew(String sku, Size size) {
        super(sku, "Cold Brew", BASE_PRICE, size);
    }

    @Override
    public BigDecimal getPrice() {
        return BASE_PRICE.multiply(sizeMultiplier());
    }
}