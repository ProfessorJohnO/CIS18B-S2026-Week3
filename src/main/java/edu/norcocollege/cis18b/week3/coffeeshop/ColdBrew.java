package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class ColdBrew extends Beverage {
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.00");

    public ColdBrew(Size size) {
        super("COLD_BREW", "Cold Brew", BASE_PRICE, size);
    }
}