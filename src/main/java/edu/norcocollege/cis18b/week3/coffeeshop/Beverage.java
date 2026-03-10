package edu.norco.cis18b.coffeeshop;
import java.math.BigDecimal;
abstract class Beverage extends MenuItem{
    public enum Size{
        SMALL,
        MEDIUM,
        LARGE
    }
    private Size size;
    
    public Beverage(String sku, String name, BigDecimal basePrice, Size size) {
        super(name, sku, basePrice);
        this.size = size;

    }
    public BigDecimal sizeMultiplier() {
        switch (size) {
            case SMALL:
                return new BigDecimal("1.00");
            case MEDIUM:
                return new BigDecimal("1.20");
            case LARGE:
                return new BigDecimal("1.40");
            default:
                return BigDecimal.ONE;
        }
    }


}
