package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

/***************************************************************************
 * Will represent a generic item that can appear on the coffee shop menu.
 * 
 * Each MenuItem has:
 * - a SKU (stock keeping unit) identifier
 * - a display name
 * - a price stored using BigDecimal for precision
 * 
 * This class performs validation to ensure that all menu items are created
 * with valid values
*/// ************************************************************************
public class MenuItem 
{
    // Unique identifier for the item
    private String sku;

    // The name shown to customers
    private String name;

    // Price of the item
    private BigDecimal price;

    /*
     * Constructs a MenuItem with the specified SKU, name, and price.
     *
     * param "sku"       | unique identifier for the item
     * param "name"      | display name of the item
     * param "price"     | price of the item
     * throws IllegalArgumentException if any argument is invalid
    */
    public MenuItem(String sku, String name, BigDecimal price) 
    {

        if (sku == null || sku.isBlank()) 
        {
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }

        if (name == null || name.isBlank()) 
        {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (price == null) 
        {
            throw new IllegalArgumentException("Price cannot be null");
        }

        if (price.compareTo(BigDecimal.ZERO) < 0) 
        {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    /*
     * Returns the SKU identifier for this menu item.
    */
    public String getSku() 
    {
        return sku;
    }

    /*
     * Returns the display name of this menu item
    */
    public String getName() 
    {
        return name;
    }

    /*
     * Returns the price of the menu item
    */
    public BigDecimal getPrice() 
    {
        return price;
    }

    /*
     * Returns a readable string representation of the menu item
    */
    @Override
    public String toString() 
    {
        return sku + " - " + name + " ($" + price + ")";
    }
}