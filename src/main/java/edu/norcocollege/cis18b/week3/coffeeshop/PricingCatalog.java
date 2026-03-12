import java.math.BigDecimal;

public class PricingCatalog
{
    private static final PricingCatalog INSTANCE = new PricingCatalog();

    private PricingCatalog() {}

    public static PricingCatalog getInstance()
    {
        return INSTANCE;
    }

    public BigDecimal getBasePrice(String productKey)
    {
        return switch (productKey)
        {
            case "LATTE" -> BigDecimal.valueOf(4.50);

            case "COLD_BREW" -> BigDecimal.valueOf(4.00);

            case "CUSTOM" -> BigDecimal.valueOf(4.25);

            default -> throw new IllegalArgumentException("Unknown product key: " + productKey);
        };
    }
}