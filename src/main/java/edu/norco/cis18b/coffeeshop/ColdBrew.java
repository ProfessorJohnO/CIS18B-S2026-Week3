package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ColdBrew extends Beverage {
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.00");

    public ColdBrew(Size size) {
        super(
                "COLD_BREW",
                "Cold Brew",
                BASE_PRICE.multiply(multiplierFor(size)).setScale(2, RoundingMode.HALF_UP),
                size
        );
    }

    private static BigDecimal multiplierFor(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("size cannot be null");
        }

        return switch (size) {
            case SMALL -> new BigDecimal("1.00");
            case MEDIUM -> new BigDecimal("1.20");
            case LARGE -> new BigDecimal("1.40");
        };
    }
}