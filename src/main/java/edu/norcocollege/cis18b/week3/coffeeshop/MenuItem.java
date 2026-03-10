
package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;

public class MenuItem 
{

    private String sku;
    private String name;
    private BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price) 
    {

        if (sku == null || sku.isBlank())
            throw new IllegalArgumentException("SKU cannot be blank");

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be blank");

        if (price == null)
            throw new IllegalArgumentException("Price cannot be null");

        if (price.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Price must be >= 0");

        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() 
    {
        return sku;
    }

    public String getName() 
    {
        return name;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    protected void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    @Override
    public String toString() 
    {
        return name + " $" + price;
    }
}