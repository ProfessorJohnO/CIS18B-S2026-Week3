package edu.norco.cis18b.week3.coffeeshop;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Collections;
class Order{
    String orderId;
    List<MenuItem> items;
    Order(String orderId){
        if (orderId == null || orderId.isBlank()) {
                throw new IllegalArgumentException("orderId cannot be null or blank");
        }
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }
    //item cannot be null
    void addItem(MenuItem item){
        if(item == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }
    List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }
    BigDecimal total() {
        BigDecimal sum = BigDecimal.ZERO;
        for (MenuItem item : items) {
            sum = sum.add(item.getPrice());
        }
        return sum;
    }
    String getOrderId() {
        return orderId;
    }



}