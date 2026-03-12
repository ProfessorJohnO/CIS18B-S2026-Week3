package edu.norco.cis18b.week3.coffeeshop; // Fixed package for the entire project section

/*
 * Main/entry point for the Coffee Shop app.
 *
 * This class creates sample menu items, adds them to an order,
 * calculates the total, and processes a payment. It demonstrates
 * the functionality implemented across the project:
 *
 * - MenuItem and Order management
 * - Beverage inheritance (Latte and ColdBrew)
 * - Builder pattern for CustomDrink
 * - Payment processing using the PaymentMethod interface
 * - PaymentReceipt generation
 */
public class App 
{

    /*
     * Main method that runs a simple example of the coffee shop system.
    */
    public static void main(String[] args) 
    {

        // Create a new order with a unique order ID
        // Using a test demo order for somebody named "Joe"
        Order order = new Order("ORD-JOE");

        /*
         * Create some beverages using the inheritance hierarchy
         * Latte and ColdBrew both extend the Beverage class
         */
        Latte latte = new Latte(Beverage.Size.MEDIUM);
        ColdBrew coldBrew = new ColdBrew(Beverage.Size.SMALL);

        /*
         * Create a customizable drink using the Builder pattern.
         * Allows for optional configuration of drink attributes
        */
        CustomDrink customDrink = new CustomDrink.Builder()
                .size(Beverage.Size.LARGE)
                .syrup(CustomDrink.Syrup.VANILLA)
                .espressoShots(2)
                .addExtra("Cinnamon")
                .build();

        // Add the beverages to the order
        order.addItem(latte);
        order.addItem(coldBrew);
        order.addItem(customDrink);

        // Display basic order information and that the system runs
        System.out.println("Coffee Shop System Running...");
        System.out.println("Order ID: " + order.getOrderId());

        // Print all items currently in the order
        System.out.println("Items in order:");
        for (MenuItem item : order.getItems()) 
        {
            System.out.println("- " + item);
        }

        // Calculate and display the total cost of the order
        System.out.println("Total: $" + order.total());

        /*
         * Process payment using a credit card.
         * CreditCardPayment implements the PaymentMethod interface
        */
        CreditCardPayment payment = new CreditCardPayment("1234");

        // Generate a receipt after payment is processed
        PaymentReceipt receipt = payment.pay(order.getOrderId(), order.total());

        // Display receipt information
        System.out.println("Payment method: " + receipt.method());
        System.out.println("Timestamp: " + receipt.timestamp());
    }
}