import java.math.BigDecimal;

public abstract class Beverage extends MenuItem
{

    public enum Size
    {
        SMALL,
        MEDIUM,
        LARGE
    }

    private Size size;

    public Beverage(String sku, String name, BigDecimal basePrice, Size size)
    {
        super(sku, name, basePrice);
        this.size = size;
    }

    public BigDecimal sizeMultiplier()
    {
        return switch (size)
        {
            case SMALL -> BigDecimal.valueOf(1.00);
            case MEDIUM -> BigDecimal.valueOf(1.20);
            case LARGE -> BigDecimal.valueOf(1.40);
        };
    }
}