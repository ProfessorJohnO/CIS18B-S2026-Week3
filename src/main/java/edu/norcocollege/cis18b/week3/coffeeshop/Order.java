package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final String orderId;
    private final List<MenuItem> items;

    public Order(String orderId) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("orderId cannot be null or blank");
        }

        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        BigDecimal sum = BigDecimal.ZERO;

        for (MenuItem item : items) {
            sum = sum.add(item.getPrice());
        }

        return sum;
    }

    public String getOrderId() {
        return orderId;
    }
}