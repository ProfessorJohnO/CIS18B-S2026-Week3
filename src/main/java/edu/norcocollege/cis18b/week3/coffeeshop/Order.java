package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***********************************************************************
 * Represents a customer's order in the coffee shop system
 * 
 * An Order contains:
 * - a unique order ID
 * - a list of MenuItem objects that have been added to the order
 * 
 * The class provides methods for adding items, retrieving the list of items,
 * and calculating the total cost of the order.
 */// *******************************************************************
public class Order
 {
    // Unique identifier for the order
    private String orderId;

    // List storing all menu items added to the order
    private List<MenuItem> items;

    /*
     * Creates a new order with the specified order ID.
     *
     * parameter: orderId        | unique identifier for the order
     * throws IllegalArgumentException if orderId is null or blank
    */
    public Order(String orderId) 
    {
        if (orderId == null || orderId.isBlank()) 
        {
            throw new IllegalArgumentException("Order ID cannot be null or blank");
        }

        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    /*
     * Adds a MenuItem to the order.
     *
     * parameter: item          | the menu item to add
     * throws IllegalArgumentException if the item is null
    */
    public void addItem(MenuItem item) 
    {

        if (item == null) 
        {
            throw new IllegalArgumentException("Item cannot be null");
        }

        items.add(item);
    }

    /* // Emphasized requirement:
     * Returns an unmodifiable view of the items in this order.
     * This is to prevent external code from modifying the internal list.
    */
    public List<MenuItem> getItems() 
    {
        return Collections.unmodifiableList(items);
    }

    /*
     * i. Calculates the total cost of all items in the order.
     * ii. return total price of the order
    */
    public BigDecimal total() 
    {

        BigDecimal total = BigDecimal.ZERO;

        for (MenuItem item : items) 
        {
            total = total.add(item.getPrice());
        }

        return total;
    }

    /*
     * Returns the unique ID of the order.
    */
    public String getOrderId() 
    {
        return orderId;
    }
}