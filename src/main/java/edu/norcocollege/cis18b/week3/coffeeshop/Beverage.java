package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public abstract class Beverage extends MenuItem {

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private final Size size;

    public Beverage(String sku, String name, BigDecimal basePrice, Size size) {
        super(sku, name, basePrice);

        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }

        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public BigDecimal sizeMultiplier() {
        switch (size) {
            case SMALL:
                return new BigDecimal("1.00");
            case MEDIUM:
                return new BigDecimal("1.20");
            case LARGE:
                return new BigDecimal("1.40");
        }

	throw new IllegalStateException("Unexpected size: " + size);
    }
}