package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Beverage extends MenuItem {

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private final Size size;

    protected Beverage(String sku, String name, BigDecimal price, Size size) {
        super(sku, name, price.setScale(2, RoundingMode.HALF_UP));

        if (size == null) {
            throw new IllegalArgumentException("size cannot be null");
        }

        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public BigDecimal sizeMultiplier() {
        return switch (size) {
            case SMALL -> new BigDecimal("1.00");
            case MEDIUM -> new BigDecimal("1.20");
            case LARGE -> new BigDecimal("1.40");
        };
    }
}