import java.math.BigDecimal;

public class Latte extends Beverage
{

    private static final BigDecimal BASE_PRICE = BigDecimal.valueOf(4.50);

    public Latte(String sku, Size size)
    {
        super(sku, "Latte", BASE_PRICE, size);
    }

    public BigDecimal price()
    {
        return basePrice.multiply(sizeMultiplier());
    }
}