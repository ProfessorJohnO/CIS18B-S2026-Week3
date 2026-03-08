package edu.norco.cis18b.week3.coffeeshop;
import java.math.BigDecimal;
public class Latte extends Beverage {
    public Latte(String sku, Size size) {
        super(sku,"Latte",
            BigDecimal.valueOf(4.50).multiply(
                size == Size.SMALL ? BigDecimal.valueOf(1.00) :
                size == Size.MEDIUM ? BigDecimal.valueOf(1.20) :
                BigDecimal.valueOf(1.40)
            ),
            size
        );
    }
}