package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * Represents a customizable drink using the Builder pattern.
*/
public class CustomDrink extends Beverage 
{

    public enum Milk 
    {
        WHOLE,
        OAT,
        ALMOND,
        SKIM
    }

    public enum Syrup 
    {
        VANILLA,
        CARAMEL,
        HAZELNUT,
        NONE
    }

    public enum Temperature 
    {
        HOT,
        ICED
    }

    private final Milk milk;
    private final Syrup syrup;
    private final Temperature temperature;
    private final int espressoShots;
    private final List<String> extras;

    /*
     * Private constructor used by the Builder.
    */
    private CustomDrink
    (
            Size size,
            Milk milk,
            Syrup syrup,
            Temperature temperature,
            int espressoShots,
            List<String> extras
    ) 
    {
        super("CUSTOM", "Custom Drink",
                calculatePrice(size, syrup, espressoShots, extras),
                size);

        this.milk = milk;
        this.syrup = syrup;
        this.temperature = temperature;
        this.espressoShots = espressoShots;
        this.extras = new ArrayList<>(extras);
    }

    /*
     * Calculates the final custom drink price:
    */
    private static BigDecimal calculatePrice
    (
            Size size,
            Syrup syrup,
            int espressoShots,
            List<String> extras
    ) 
    {
        BigDecimal total = new BigDecimal("4.25");

        BigDecimal multiplier = switch (size) 
        {
            case SMALL -> new BigDecimal("1.00");
            case MEDIUM -> new BigDecimal("1.20");
            case LARGE -> new BigDecimal("1.40");
        };

        total = total.multiply(multiplier);
        // For > than 1
        if (espressoShots > 1) 
        {
            total = total.add(
                    new BigDecimal("0.75").multiply(BigDecimal.valueOf(espressoShots - 1))
            );
        }
        // For none
        if (syrup != Syrup.NONE) 
        {
            total = total.add(new BigDecimal("0.50"));
        }

        // Update total
        total = total.add
        (
                new BigDecimal("0.25").multiply(BigDecimal.valueOf(extras.size()))
        );

        return total.setScale(2);
    }

    /*
     * Builder for creating CustomDrink objects
     */
    public static class Builder 
    {
        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private final List<String> extras = new ArrayList<>();

        public Builder size(Size size) 
        {
            this.size = size;
            return this;
        }

        public Builder milk(Milk milk) 
        {
            this.milk = milk;
            return this;
        }

        public Builder syrup(Syrup syrup) 
        {
            this.syrup = syrup;
            return this;
        }

        public Builder temperature(Temperature temperature) 
        {
            this.temperature = temperature;
            return this;
        }

        // User input validation
        public Builder espressoShots(int shots) 
        {
            if (shots < 1) 
            {
                throw new IllegalArgumentException("Espresso shots must be at least 1");
            }

            this.espressoShots = shots;
            return this;
        }

        public Builder addExtra(String extra) 
        {
            if (extra == null || extra.isBlank()) 
            {
                throw new IllegalArgumentException("Extra cannot be null or blank");
            }

            this.extras.add(extra);
            return this;
        }

        public CustomDrink build() 
        {
            return new CustomDrink(size, milk, syrup, temperature, espressoShots, extras);
        }
    }
}