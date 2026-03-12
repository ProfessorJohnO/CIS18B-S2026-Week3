package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

/*
 * Represents a latte beverage in the coffee shop system
 * A Latte has a fixed base price that changes depending on size
*/
public class Latte extends Beverage 
{

    // Base price for a small latte
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.50");

    /*
     * Constructs a Latte with the specified size.
     *
     * parameter: size      | size of the latte
    */
    public Latte(Size size) 
    {
        super("LATTE", "Latte", calculatePrice(size), size);
    }

    /*
     * Calculates the final latte price based on size
     *
     * parameter: size      | size of the latte
     * - returns final price of the latte
     * - throws IllegalArgumentException if size null
    */
private static BigDecimal calculatePrice(Size size) 
{
    if (size == null) 
    {
        throw new IllegalArgumentException("Size cannot be null");
    }

    BigDecimal multiplier = switch (size) 
    { // Switch cases for price versus size
        case SMALL -> new BigDecimal("1.00");
        case MEDIUM -> new BigDecimal("1.20");
        case LARGE -> new BigDecimal("1.40");
    };

    return BASE_PRICE.multiply(multiplier).setScale(2);
}
}