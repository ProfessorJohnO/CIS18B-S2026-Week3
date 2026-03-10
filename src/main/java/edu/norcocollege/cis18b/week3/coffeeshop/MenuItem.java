package edu.norco.cis18b.coffeeshop;
import java.math.BigDecimal;
class MenuItem {
    private String name;
    private String sku;
    private BigDecimal price;
    public MenuItem(String name, String sku, BigDecimal price) {
        if(name == null||name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");}
        if(sku == null||sku.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be null or blank");}
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to zero");
        }

        this.name = name;
        this.sku = sku;
        this.price = price;}
    public BigDecimal getPrice() {
    return price;
    }
    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }
}
