package edu.norco.cis18b.week3.coffeeshop;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class CustomDrink extends Beverage {
    public enum Milk {
        WHOLE, OAT, ALMOND, SKIM
    }
    public enum Syrup {
        VANILLA, CARAMEL, HAZELNUT, NONE
    }
    public enum Temperature {
        HOT, ICED
    }
    private Milk milk;
    private Syrup syrup;
    private Temperature temperature;
    private int espressoShots;
    private List<String> extras;
    private CustomDrink(String sku,
                        Size size,
                        Milk milk,
                        Syrup syrup,
                        Temperature temperature,
                        int espressoShots,
                        List<String> extras) {
        super(sku, "Custom Drink", calculatePrice(size, syrup, espressoShots, extras), size);
        this.milk = milk;
        this.syrup = syrup;
        this.temperature = temperature;
        this.espressoShots = espressoShots;
        this.extras = extras;
    }
    private static BigDecimal calculatePrice(Size size, Syrup syrup, int shots, List<String> extras) {
        BigDecimal price = BigDecimal.valueOf(4.25);
        if (shots > 1) {
            price = price.add(BigDecimal.valueOf((shots - 1) * 0.75));
        }
        if (syrup != Syrup.NONE) {
            price = price.add(BigDecimal.valueOf(0.50));
        }
        price = price.add(BigDecimal.valueOf(extras.size() * 0.25));
        if (size == Size.MEDIUM) {
            price = price.multiply(BigDecimal.valueOf(1.20));
        } else if (size == Size.LARGE) {
            price = price.multiply(BigDecimal.valueOf(1.40));
        }
        return price;
    }
    public static class Builder {
        private String sku;
        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private List<String> extras = new ArrayList<>();
        public Builder(String sku) {
            this.sku = "Cutom";
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
                throw new IllegalArgumentException("espressoShots must be >= 1");
            }
            this.espressoShots = shots;
            return this;
        }
        public Builder addExtra(String extra) {
            if (extra == null || extra.isBlank()) {
                throw new IllegalArgumentException("extra cannot be null or blank");
            }
            extras.add(extra);
            return this;
        }
        public CustomDrink build() {
            return new CustomDrink(
                    sku,
                    size,
                    milk,
                    syrup,
                    temperature,
                    espressoShots,
                    extras
            );
        }
    }
}