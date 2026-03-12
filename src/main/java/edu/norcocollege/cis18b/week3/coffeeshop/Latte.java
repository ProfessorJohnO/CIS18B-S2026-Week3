package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class Latte extends Beverage {
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.50");

    public Latte(Size size) {
        super("LATTE", "Latte", BASE_PRICE, size);
    }
}