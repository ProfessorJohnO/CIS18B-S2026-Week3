package edu.norco.cis18b.coffeeshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

import edu.norco.cis18b.coffeeshop.grading.Points;
import edu.norco.cis18b.coffeeshop.grading.ScoreExtension;

@Points(2)
@ExtendWith(ScoreExtension.class)
public class Part4Test {

    @Test
    void customDrink_defaultsWork() {
        CustomDrink d = new CustomDrink.Builder().build();
        // compare using compareTo to ignore scale differences
        assertTrue(d.getPrice().compareTo(new BigDecimal("5.10")) == 0);
    }

    @Test
    void customDrink_pricingRules() {
        CustomDrink d = new CustomDrink.Builder()
                .size(Beverage.Size.LARGE)
                .espressoShots(3)
                .syrup(CustomDrink.Syrup.VANILLA)
                .addExtra("Cinnamon")
                .addExtra("Whipped cream")
                .build();

        assertTrue(d.getPrice().compareTo(new BigDecimal("8.45")) == 0);
    }

    @Test
    void customDrink_builderValidations() {
        assertThrows(IllegalArgumentException.class, () -> new CustomDrink.Builder().espressoShots(0));
        assertThrows(IllegalArgumentException.class, () -> new CustomDrink.Builder().addExtra("   "));
    }

    @Test
    void pricingCatalog_singletonAndPrices() {
        PricingCatalog a = PricingCatalog.getInstance();
        PricingCatalog b = PricingCatalog.getInstance();
        assertSame(a, b);

        assertTrue(a.getBasePrice("LATTE").compareTo(new BigDecimal("4.50")) == 0);
        assertTrue(a.getBasePrice("COLD_BREW").compareTo(new BigDecimal("4.00")) == 0);
        assertTrue(a.getBasePrice("CUSTOM").compareTo(new BigDecimal("4.25")) == 0);
        assertThrows(IllegalArgumentException.class, () -> a.getBasePrice("ESPRESSO"));
    }
}