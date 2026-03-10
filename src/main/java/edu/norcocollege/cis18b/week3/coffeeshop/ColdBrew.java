package edu.norco.cis18b.coffeeshop;
import java.math.BigDecimal;
public class ColdBrew extends Beverage {
    public ColdBrew(Size size) {
        super("COLDBREW","Cold Brew",BigDecimal.valueOf(4.00).multiply(getMultiplier(size)),size);
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