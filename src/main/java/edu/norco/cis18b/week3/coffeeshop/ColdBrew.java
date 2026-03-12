package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

/*
 * Represents a cold brew beverage in the coffee shop system.
 * Cold brew has a base price that changes depending on size like other menu options
*/
public class ColdBrew extends Beverage 
{

    // Base price for a small cold brew
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.00");

    /*
     * Constructs a ColdBrew with the specified size.
     *
     * parameter: size       | size of the cold brew
    */
    public ColdBrew(Size size) 
    {
        super("COLD_BREW", "Cold Brew", calculatePrice(size), size);
    }

    /*
     * Calculates the final cold brew price based on size.
     *
     * parameter: size      | beverage size
     * returns the final price
     * throws IllegalArgumentException if null
    */
private static BigDecimal calculatePrice(Size size) 
{
    if (size == null) 
    {
        throw new IllegalArgumentException("Size cannot be null");
    }

    BigDecimal multiplier = switch (size) 
    {
        // Switch cases for price vs. size
        case SMALL -> new BigDecimal("1.00");
        case MEDIUM -> new BigDecimal("1.20");
        case LARGE -> new BigDecimal("1.40");
    };

    return BASE_PRICE.multiply(multiplier).setScale(2);
}
}