package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

/*
 * Represents a beverage sold by the coffee shop app
 *
 * Beverage is a subclass of MenuItem that adds a size
 * and a size-based multiplier used for the drink pricing.
*/
public abstract class Beverage extends MenuItem 
{

    /*
     * Available beverage sizes:
    */
    public enum Size 
    {
        SMALL,
        MEDIUM,
        LARGE
    }

    // Size of the beverage
    private Size size;

    /*
     * Constructs a beverage with the given SKU, name, price, and size.
     *
     * paramter: sku        | unique identifier for the beverage
     * paramter: name       | display name of the beverage
     * parameter: price     | price of the beverage
     * parameter: size      | size of the beverage
     * throws IllegalArgumentException if size is null
    */
    public Beverage(String sku, String name, BigDecimal price, Size size) 
    {
        super(sku, name, price);

        if (size == null) 
        {
            throw new IllegalArgumentException("Size cannot be null");
        }

        this.size = size;
    }

    /*
     * Returns the size of the beverage.
    */
    public Size getSize() 
    {
        return size;
    }

    /*
     * Returns the multiplier associated with the beverage size.
     *
     * SMALL  = 1.00
     * MEDIUM = 1.20
     * LARGE  = 1.40
     *
     * - Return size multiplier as a BigDecimal
    */
    public BigDecimal sizeMultiplier() 
    {
        return switch (size) 
        {
            case SMALL -> new BigDecimal("1.00");
            case MEDIUM -> new BigDecimal("1.20");
            case LARGE -> new BigDecimal("1.40");
        };
    }
}