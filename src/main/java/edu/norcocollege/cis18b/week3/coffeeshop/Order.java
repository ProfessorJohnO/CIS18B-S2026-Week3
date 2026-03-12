class Order
{
    private String orderId;
    private List<MenuItem> items;

    public Order(String orderId, List<MenuItem> items)
    {
        if(orderId != null && orderId != "")
        {
            this.orderId = orderId;
            this.items = items;
        }
    }

    public void addItem(MenuItem item)
    {
        if(item != null)
        {
            items.add(item);
        }
    }

    public List<MenuItem> getItems()
    {
        List<MenuItem> temp;

        for(var item : items)
        {
            temp.add(item);
        }

        return temp;
    }

    public BigDecimal total()
    {
        BigDecimal total;

        for(var i : items)
        {
            total += i.getPrice();
        }

        return total;
    }

    public String getOrderId()
    {
        return orderId;
    }
}