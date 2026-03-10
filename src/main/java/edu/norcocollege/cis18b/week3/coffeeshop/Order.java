
package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order 
{

    private String orderId;
    private List<MenuItem> items = new ArrayList<>();

    public Order(String orderId) 
    {

        if(orderId == null || orderId.isBlank())
            throw new IllegalArgumentException("OrderId cannot be blank");

        this.orderId = orderId;
    }

    public void addItem(MenuItem item)
    {

        if(item == null)
            throw new IllegalArgumentException("Item cannot be null");

        items.add(item);
    }

    public List<MenuItem> getItems()
    {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total()
    {

        BigDecimal total = BigDecimal.ZERO;

        for(MenuItem item : items)
            {
            total = total.add(item.getPrice());
        }

        return total;
    }

    public String getOrderId()
    {
        return orderId;
    }
}