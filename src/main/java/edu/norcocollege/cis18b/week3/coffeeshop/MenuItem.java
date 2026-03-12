import java.math.BigDecimal;

class MenuItem
{
    private String sku;
    private String name;
    private BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price)
    {
        if((sku != null && sku != "") && (name != null && name != "") && (price != null && (price == 0 || Math.max(0, price) == price)))
        {
            this.sku = sku;
            this.name = name;
            this.price = price;
        }
        else
        {
            throw IllegalArgumentException;
        }
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
    
    public String toString()
    {
        return sku + "\n" + name + "\n" + price;
    }
}