package edu.norco.cis18b.week3.coffeeshop;
import java.util.List;
import java.util.ArrayList;
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

    void addItem(MenuItem item){
        if(item == null){
            throw new IllegalArgumentException("Item cannont be null")
        }

    }
}