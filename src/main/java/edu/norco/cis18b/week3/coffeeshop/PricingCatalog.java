package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

/*
 * Singleton catalog that stores base prices for coffee shop products.
*/
public class PricingCatalog 
{

    private static final PricingCatalog INSTANCE = new PricingCatalog();

    /*
     * Private constructor for singleton pattern.
    */
    private PricingCatalog() 
    {
    }

    /*
     * Returns the single instance of PricingCatalog
    */
    public static PricingCatalog getInstance() 
    {
        return INSTANCE;
    }

    /*
     * Returns the base price for the given product key
     *
     * parameter: productKey | product identifier
     * returns the base price
     * throws IllegalArgumentException if product key is unknown
    */
    public BigDecimal getBasePrice(String productKey) 
    {
        return switch (productKey) 
        {
            case "LATTE" -> new BigDecimal("4.50");
            case "COLD_BREW" -> new BigDecimal("4.00");
            case "CUSTOM" -> new BigDecimal("4.25");
            default -> throw new IllegalArgumentException("Unknown product key");
        };
    }
}