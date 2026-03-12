import java.math.BigDecimal;

public calss ColdBrew extends Beverage
{
    public ColdBrew(Size size)
    {
        super("CB-" + size, "Cold Brew", BigDecimal.valueOf(4.00), size);
    }

    @Override
    protected BigDecimal getBasePrice()
    {
        return BigDecimal.valueOf(4.00);
    }
}