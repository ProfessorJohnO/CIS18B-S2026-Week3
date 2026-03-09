package edu.norco.cis18b.week3.coffeeshop;
import java.math.BigDecimal;
public class ColdBrew extends Beverage {
    public ColdBrew(String sku, Size size) {
        super(sku,"Cold Brew",BigDecimal.valueOf(4.00).multiply(getMultiplier(size)),size);
    }
    private static BigDecimal getMultiplier(Size size) {
        switch (size) {
            case SMALL:
                return BigDecimal.valueOf(1.00);
            case MEDIUM:
                return BigDecimal.valueOf(1.20);
            case LARGE:
                return BigDecimal.valueOf(1.40);
            default:
                return BigDecimal.ONE;
        }
    }
}