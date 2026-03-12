package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.Map;

public class PricingCatalog {

    private static final PricingCatalog INSTANCE = new PricingCatalog();

    private final Map<String, BigDecimal> prices = Map.of(
        "LATTE", new BigDecimal("4.50"),
        "COLD_BREW", new BigDecimal("4.00"),
        "CUSTOM", new BigDecimal("4.25");
    );

    private PricingCatalog() {
    }

    public static PricingCatalog getInstance() {
        return INSTANCE;
    }

    public BigDecimal getBasePrice(String productKey) {
        BigDecimal price = prices.get(productKey);
        if (price == null) {
            throw new IllegalArgumentException("Unknown product key: " + productKey);
        }
        return price;
    }
}