package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class ColdBrew extends Beverage {

    private static final BigDecimal BASE_PRICE = new BigDecimal("4.00");

    public ColdBrew(String sku, Size size) {
        super(sku, "Cold Brew", BASE_PRICE.multiply(sizeMultiplier(size)), size);
    }

    private static BigDecimal sizeMultiplier(Size size) {

        switch (size) {
            case SMALL:
                return new BigDecimal("1.00");

            case MEDIUM:
                return new BigDecimal("1.20");

            case LARGE:
                return new BigDecimal("1.40");

            default:
                throw new IllegalStateException("Unexpected size");
        }
    }
}