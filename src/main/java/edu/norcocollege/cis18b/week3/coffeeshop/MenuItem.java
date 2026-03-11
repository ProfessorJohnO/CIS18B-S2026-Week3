public class MenuItem {
    private string sku = " ";
    private string name = " ";
    private bigDecimal price = 0.0;

    // Constructors
    public MenuItem(String name, String sku, BigDecial price) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Error! Name cannot be blank");
        }
        if(sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("Error! Sku cannot be blank");
        }
        if (price == null || price.compareTo(bigDecimal.ZERO) < 0 ) {
            throw new IllegalArgumentException("Error! Price must be a valid number");
        }

        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    // Get Methods
    String getSku() {
        return sku;
    }

    String getName() {
        return nam;
    }

    BigDecimal getPrice() {
        return price;
    }
}