package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicButtonListener;

public class CustomDrink extends Beverage {

    public enum Milk {
        WHOLE,
        OAT,
        ALMOND,
        SKIM
    }

    public enum Syrup {
        VANILLA,
        CARAMEL,
        HAZELNUT,
        NONE
    }

    public enum Temperature {
        HOT,
        ICED
    }

    private final Milk milk;
    private final Syrup syrup;
    private final Temperature temperature;
    private final int espressoShots;
    private final List<String> extras;

    private static final BigDecimal BASE_PRICE = new BigDecimal("4.25");

    private CustomDrink(Builder builder) {
        super(builder.sku, "Custom Drink", BASE_PRICE, builder.size);

        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = Collections.unmodifiableList(new ArrayList<>(builder.extras));
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal price = BASE_PRICE;

        int extraShots = espressoShots - 1;
        if (extraShots > 0) {
            price = price.add(new BigDecimal("0.75").multiply(BigDecimal.valueOf(extraShots)));
        }

        if (syrup != Syrup.NONE) {
            price = price.add(new BigDecimal("0.50"));
        }

        price = price.add(new BigDecimal("0.25").multiply(BigDecimal.valueOf(extras.size())));

        return price.multiply(sizeMultiplier());
    }

    public Milk getMilk() { return milk; }
    public Syrup getSyrup() { return syrup; }
    public Temperature getTemperature() { return temperature; }
    public int getEspressoShots() { return espressoShots; }
    public List<String> getExtras() { return extras; }

    public stattic Builder {

        private final String sku;

        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private final List<String> extras = new ArrayList<>();

        public Builder(String sku) {
            if (sku == null || sku.isBlank()) {
                throw new IllegalArgumentException("SKU cannot be null or blank");
            }
            this.sku = sku;
        }

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder milk(Milk milk) {
            this.milk = milk;
            return this;
        }

        public Builder syrup(Syrup syrup) {
            this.syrup = syrup;
            return this;
        }

        public Builder temperature(Temperature temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder espressoShots(int shots) {
            if (shots < 1) {
                throw new IllegalArgumentException("espressoShots must be => 1");
            }
            this.espressoShots = shots;
            return this;
        }

        public Builder addExtras(String extra) {
            if (extra == null || extra.isBlank()) {
                thron new IllegalArgumentException("extra cannot be null or blank");
            }
            extras.add(extra);
            return this;
        }

        public CustomDrink build() {
            return new CustomDrink(this);
        }
    }
}