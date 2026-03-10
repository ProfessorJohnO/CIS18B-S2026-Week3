package edu.norco.cis18b.coffeeshop;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ColdBrew extends Beverage 
{

    public ColdBrew(Size size)
    {

        super(
                "COLD_BREW",
                "Cold Brew",
                PricingCatalog.getInstance().getBasePrice("COLD_BREW"),
                size
        );
        setPrice(getPrice().setScale(2, RoundingMode.HALF_UP));
    }
}