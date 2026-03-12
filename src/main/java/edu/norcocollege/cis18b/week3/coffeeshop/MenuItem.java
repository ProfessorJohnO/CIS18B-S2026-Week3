import java.math.BigDecimal;
import java.util.Objects;

public class MenuItem 
{
    private final String sku;
    private final String name;
    private final BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price) 
    {
        if (sku == null || sku.trim().isEmpty()) 
            {
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        if (name == null || name.trim().isEmpty()) 
            {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (price == null) 
            {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) 
            {
            throw new IllegalArgumentException("Price must be greater than or equal to zero");
        }

        this.sku = sku.trim();
        this.name = name.trim();
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

    @Override
    public String toString() 
    {
        return "MenuItem{sku='" + sku + "', name='" + name + "', price=" + price + "}";
    }
}