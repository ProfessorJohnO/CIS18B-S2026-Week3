import java.math.BigDecimal;

public abstract class Beverage extends MenuItem
{
    public enum Size
    {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public Beverage(String sku, String name, BigDecimal basePrice, Size size)
    {
        super(sku, name, basePrice);
        if (size == null)
        {
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.size = size;
    }

    protected abstract BigDecimalgetBasePrice();

    public size getSize()
    {
        return size;
    }

    public BigDecimal sizeMultiplier()
    {
        return switch (size)
        {
            case SMALL  -> BigDecimal.valueOf(1.00);
            case MEDIUM -> BigDecimal.valueOf(1.20);
            case LARGE  -> BigDecimal.valueOf(1.40);
        };
    }
    @Override
    public BigDecimal getPrice()
    {
        return getBasePrice().multiply(sizeMultiplier());
    }
}