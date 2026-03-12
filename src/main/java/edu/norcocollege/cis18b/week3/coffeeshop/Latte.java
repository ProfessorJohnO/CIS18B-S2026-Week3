import java.math.BigDecimal;

public class Latte extends Beverage
{

    public Latte(Size size)
    {
        super("LATTE-" + size, "Latte", BigDecimal.valueOf(4.50), size);
    }

    @Override
    protected BigDecimal getBasePrice()
    {
        return BigDecimal.valueOf(4.50);
    }
}