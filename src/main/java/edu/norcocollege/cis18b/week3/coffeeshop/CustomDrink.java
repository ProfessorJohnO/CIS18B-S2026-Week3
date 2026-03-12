package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomDrink extends Beverage {
    public enum Milk { WHOLE, OAT, ALMOND, SKIM }
    public enum Syrup { VANILLA, CARAMEL, HAZELNUT, NONE }
    public enum Temperature { HOT, ICED }

    private final Milk milk;
    private final Syrup syrup;
    private final Temperature temperature;
    private final int espressoShots;
    private final List<String> extras;
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.25");

    private CustomDrink(Builder builder) {
        super("CUSTOM", "Custom Drink", BASE_PRICE, builder.size);
        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = new ArrayList<>(builder.extras);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal price = BASE_PRICE;
        if (espressoShots > 1) {
            price = price.add(new BigDecimal("0.75").multiply(new BigDecimal(espressoShots - 1)));
        }
        if (syrup != Syrup.NONE) {
            price = price.add(new BigDecimal("0.50"));
        }
        price = price.add(new BigDecimal("0.25").multiply(new BigDecimal(extras.size())));
        return price.multiply(sizeMultiplier());
    }

    public static class Builder {
        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private final List<String> extras = new ArrayList<>();

        public Builder size(Size size) {
            if (size == null) throw new IllegalArgumentException("Size cannot be null");
            this.size = size;
            return this;
        }

        public Builder milk(Milk milk) {
            if (milk == null) throw new IllegalArgumentException("Milk cannot be null");
            this.milk = milk;
            return this;
        }

        public Builder syrup(Syrup syrup) {
            if (syrup == null) throw new IllegalArgumentException("Syrup cannot be null");
            this.syrup = syrup;
            return this;
        }

        public Builder temperature(Temperature temperature) {
            if (temperature == null) throw new IllegalArgumentException("Temperature cannot be null");
            this.temperature = temperature;
            return this;
        }

        public Builder espressoShots(int shots) {
            if (shots < 1) throw new IllegalArgumentException("Espresso shots must be at least 1");
            this.espressoShots = shots;
            return this;
        }

        public Builder addExtra(String extra) {
            if (extra == null || extra.trim().isEmpty()) {
                throw new IllegalArgumentException("Extra cannot be null or blank");
            }
            extras.add(extra);
            return this;
        }

        public CustomDrink build() {
            return new CustomDrink(this);
        }
    }

    public Milk getMilk() { return milk; }
    public Syrup getSyrup() { return syrup; }
    public Temperature getTemperature() { return temperature; }
    public int getEspressoShots() { return espressoShots; }
    public List<String> getExtras() { return new ArrayList<>(extras); }
}