
package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Latte extends Beverage 
{

    public Latte(Size size) {

    super(
        "LATTE",
        "Latte",
        PricingCatalog.getInstance().getBasePrice("LATTE"),
        size
    );

    setPrice(getPrice().stripTrailingZeros().setScale(2));
        }
    }