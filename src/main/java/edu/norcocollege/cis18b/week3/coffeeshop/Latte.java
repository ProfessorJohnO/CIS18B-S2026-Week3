package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class Latte extends Beverage {

    private static final BigDecimal BASE_PRICE = new BigDecimal("4.50");

    public Latte(String sku, Size size) {
        super(sku, "Latte", BASE_PRICE, size);
    }

    @Override
    public BigDecimal getPrice() {
        return BASE_PRICE.multiply(sizeMultiplier());
    }
}