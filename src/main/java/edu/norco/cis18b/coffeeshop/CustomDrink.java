package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomDrink extends Beverage {
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.25");
    private static final BigDecimal EXTRA_SHOT_PRICE = new BigDecimal("0.75");
    private static final BigDecimal SYRUP_PRICE = new BigDecimal("0.50");
    private static final BigDecimal EXTRA_PRICE = new BigDecimal("0.25");

    public enum Milk {
        WHOLE, OAT, ALMOND, SKIM
    }

    public enum Syrup {
        VANILLA, CARAMEL, HAZELNUT, NONE
    }

    public enum Temperature {
        HOT, ICED
    }

    private final Milk milk;
    private final Syrup syrup;
    private final Temperature temperature;
    private final int espressoShots;
    private final List<String> extras;

    private CustomDrink(Builder builder) {
        super("CUSTOM", "Custom Drink", builder.calculateFinalPrice(), builder.size);
        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = List.copyOf(builder.extras);
    }

    public Milk getMilk() {
        return milk;
    }

    public Syrup getSyrup() {
        return syrup;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public int getEspressoShots() {
        return espressoShots;
    }

    public List<String> getExtras() {
        return Collections.unmodifiableList(extras);
    }

    public static class Builder {
        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private final List<String> extras = new ArrayList<>();

        public Builder() {
        }

        public Builder size(Size size) {
            if (size == null) {
                throw new IllegalArgumentException("size cannot be null");
            }
            this.size = size;
            return this;
        }

        public Builder milk(Milk milk) {
            if (milk == null) {
                throw new IllegalArgumentException("milk cannot be null");
            }
            this.milk = milk;
            return this;
        }

        public Builder syrup(Syrup syrup) {
            if (syrup == null) {
                throw new IllegalArgumentException("syrup cannot be null");
            }
            this.syrup = syrup;
            return this;
        }

        public Builder temperature(Temperature temperature) {
            if (temperature == null) {
                throw new IllegalArgumentException("temperature cannot be null");
            }
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
            this.extras.add(extra);
            return this;
        }

        public CustomDrink build() {
            return new CustomDrink(this);
        }

        private BigDecimal calculateFinalPrice() {
            BigDecimal multiplier = switch (size) {
                case SMALL -> new BigDecimal("1.00");
                case MEDIUM -> new BigDecimal("1.20");
                case LARGE -> new BigDecimal("1.40");
            };

            BigDecimal total = BASE_PRICE.multiply(multiplier);

            if (espressoShots > 1) {
                total = total.add(
                        EXTRA_SHOT_PRICE.multiply(BigDecimal.valueOf(espressoShots - 1))
                );
            }

            if (syrup != Syrup.NONE) {
                total = total.add(SYRUP_PRICE);
            }

            total = total.add(EXTRA_PRICE.multiply(BigDecimal.valueOf(extras.size())));

            return total.setScale(2, RoundingMode.HALF_UP);
        }
    }
}