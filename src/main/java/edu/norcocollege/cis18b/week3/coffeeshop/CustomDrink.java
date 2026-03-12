import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomDrink extends Beverage
{

    public enum Milk
    {
        WHOLE, OAT, ALMOND, SKIM
    }

    public enum Syrup
    {
        VANILLA, CARAMEL, HAZELNUT, NONE
    }

    public enum Temperature
    {
        HOT, ICED
    }

    private Milk milk;
    private Syrup syrup;
    private Temperature temperature;
    private int espressoShots;
    private List<String> extras;

    private static final BigDecimal BASE_PRICE = BigDecimal.valueOf(4.25);

    private CustomDrink(Builder builder)
    {
        super(builder.sku, "Custom Drink", BASE_PRICE, builder.size);
        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = builder.extras;
    }

    public BigDecimal price()
    {

        BigDecimal price = basePrice;

        if (espressoShots > 1)
        {
            int extraShots = espressoShots - 1;
            price = price.add(BigDecimal.valueOf(0.75).multiply(BigDecimal.valueOf(extraShots)));
        }

        if (syrup != Syrup.NONE)
        {
            price = price.add(BigDecimal.valueOf(0.50));
        }

        price = price.add(BigDecimal.valueOf(0.25).multiply(BigDecimal.valueOf(extras.size())));

        return price.multiply(sizeMultiplier());
    }

    public static class Builder
    {
        private String sku;

        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;

        private List<String> extras = new ArrayList<>();

        public Builder(String sku)
        {
            this.sku = sku;
        }

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
            if (shots < 1)
            {
                throw new IllegalArgumentException("Espresso shots must be >= 1");
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

            extras.add(extra);
            return this;
        }

        public CustomDrink build()
        {
            return new CustomDrink(this);
        }
    }
}