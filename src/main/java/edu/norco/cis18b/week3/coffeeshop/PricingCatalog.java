package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class PricingCatalog {

    private static PricingCatalog instance;

    private PricingCatalog() {}

    public static PricingCatalog getInstance() {

        if (instance == null) {
            instance = new PricingCatalog();
        }

        return instance;
    }

    public BigDecimal getBasePrice(String productKey) {

        switch (productKey) {

            case "LATTE":
                return new BigDecimal("4.50");

            case "COLD_BREW":
                return new BigDecimal("4.00");

            case "CUSTOM":
                return new BigDecimal("4.25");

            default:
                throw new IllegalArgumentException("Unknown product key");
        }
    }
}