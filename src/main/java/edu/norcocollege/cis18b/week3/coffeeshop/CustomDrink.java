import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomDrink extends Beverage 
{

    public enum Milk {WHOLE, OAT, ALMOND, SKIM}
    public enum Syrup {VANILLA, CARAMEL, HAZELNUT, NONE}
    public enum Temperature {HOT, ICED}

    private final Milk milk;
    private final Syrup syrup;
    private final Temperature temperature;
    private final int espressoShots;
    private final List<String> extras;

    private CustomDrink(Builder builder) 
    {
        super("CUSTOM-" + builder.size, "Custom Drink", BigDecimal.valueOf(4.25), builder.size);
        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = Collections.unmodifiableList(new ArrayList<>(builder.extras));
    }

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

        public Builder espressoShots(int shots) 
        {
            this.espressoShots = shots;
            return this;
        }

        public Builder addExtra(String extra) 
        {
            if (extra == null || extra.trim().isEmpty()) 
                {
                    throw new IllegalArgumentException("Extra cannot be null or blank");
                }
            this.extras.add(extra.trim());
            return this;
        }

        public CustomDrink build() 
        {
            if (espressoShots < 1) 
                {
                    throw new IllegalStateException("Espresso shots must be >= 1");
                }
            return new CustomDrink(this);
        }
    }

    @Override
    protected BigDecimal getBasePrice() 
    {
        BigDecimal base = BigDecimal.valueOf(4.25);

        if (espressoShots > 1) 
            {
                base = base.add(BigDecimal.valueOf(0.75).multiply(BigDecimal.valueOf(espressoShots - 1)));
            }

        if (syrup != Syrup.NONE) 
            {
                base = base.add(BigDecimal.valueOf(0.50));
            }

        base = base.add(BigDecimal.valueOf(0.25).multiply(BigDecimal.valueOf(extras.size())));

        return base;
    }

    @Override
    public BigDecimal getPrice() 
    {
        return getBasePrice().multiply(sizeMultiplier());
    }
}