package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;

public class MenuItem {

    private String sku;
    private String name;
    private BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price) {

        if(sku == null || sku.isBlank()){
            throw new IllegalArgumentException();
        }

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException();
        }

        if(price == null || price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException();
        }

        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku(){
        return sku;
    }

    public String getName(){
        return name;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public String toString(){
        return name + " " + price;
    }
}