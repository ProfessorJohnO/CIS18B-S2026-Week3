
package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomDrink extends Beverage 
{

    public enum Milk {WHOLE, OAT, ALMOND, SKIM}
    public enum Syrup {VANILLA, CARAMEL, HAZELNUT, NONE}
    public enum Temperature {HOT, ICED}

    private Milk milk;
    private Syrup syrup;
    private Temperature temperature;
    private int espressoShots;
    private List<String> extras;

    private CustomDrink(Builder builder)
    {

        super
        (
                "CUSTOM",
                "Custom Drink",
                PricingCatalog.getInstance().getBasePrice("CUSTOM"),
                builder.size
        );

        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = builder.extras;

        BigDecimal price = getPrice();

    if (espressoShots > 1)
        price = price.add(new BigDecimal("0.75")
            .multiply(new BigDecimal(espressoShots - 1)));

    if (syrup != Syrup.NONE)
        price = price.add(new BigDecimal("0.50"));

    price = price.add(new BigDecimal("0.25")
        .multiply(new BigDecimal(extras.size())));

setPrice(price.setScale(2, java.math.RoundingMode.HALF_UP));
    }

    public static class Builder 
    {

        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private List<String> extras = new ArrayList<>();

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

        public Builder espressoShots(int shots)
        {

            if(shots < 1)
                throw new IllegalArgumentException("Shots must be >=1");

            this.espressoShots = shots;
            return this;
        }

        public Builder addExtra(String extra)
        {

            if(extra == null || extra.isBlank())
                throw new IllegalArgumentException("Invalid extra");

            extras.add(extra);
            return this;
        }

        public CustomDrink build()
        {
            return new CustomDrink(this);
        }
    }
}