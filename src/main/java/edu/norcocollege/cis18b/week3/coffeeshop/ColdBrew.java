import java.math.BigDecimal;

public class ColdBrew extends Beverage
{

    private static final BigDecimal BASE_PRICE = BigDecimal.valueOf(4.00);

    public ColdBrew(String sku, Size size)
    {
        super(sku, "Cold Brew", BASE_PRICE, size);
    }

    public BigDecimal price()
    {
        return basePrice.multiply(sizeMultiplier());
    }
}