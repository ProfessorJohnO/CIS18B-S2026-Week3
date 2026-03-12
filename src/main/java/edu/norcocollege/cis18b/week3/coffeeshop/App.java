package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Coffee Shop Ordering System Test ===\n");

        // ============================================
        // Part A - MenuItem and Order
        // ============================================
        System.out.println("--- Part A: MenuItem and Order ---");
        
        // Create menu items
        MenuItem coffee = new MenuItem("DRINK001", "House Coffee", new BigDecimal("2.50"));
        MenuItem muffin = new MenuItem("FOOD001", "Blueberry Muffin", new BigDecimal("3.25"));
        
        System.out.println("Menu Items:");
        System.out.println("  " + coffee);
        System.out.println("  " + muffin);
        
        // Create an order
        Order order1 = new Order("ORD-1001");
        order1.addItem(coffee);
        order1.addItem(muffin);
        
        System.out.println("\nOrder ID: " + order1.getOrderId());
        System.out.println("Items in order:");
        for (MenuItem item : order1.getItems()) {
            System.out.println("  - " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + order1.total());
        
        // ============================================
        // Part B - Beverage Inheritance
        // ============================================
        System.out.println("\n--- Part B: Beverage Inheritance ---");
        
        Latte latte = new Latte(Beverage.Size.MEDIUM);
        ColdBrew coldBrew = new ColdBrew(Beverage.Size.LARGE);
        
        System.out.println("Latte (MEDIUM): $" + latte.getPrice());
        System.out.println("Cold Brew (LARGE): $" + coldBrew.getPrice());
        
        // ============================================
        // Part C - Payment System
        // ============================================
        System.out.println("\n--- Part C: Payment System ---");
        
        // Credit card payment
        CreditCardPayment creditCard = new CreditCardPayment("1234");
        PaymentReceipt receipt1 = creditCard.pay(order1.getOrderId(), order1.total());
        System.out.println("Credit Card Payment:");
        System.out.println("  Receipt: " + receipt1);
        
        // Gift card payment
        GiftCardPayment giftCard = new GiftCardPayment(new BigDecimal("20.00"));
        System.out.println("\nGift Card initial balance: $" + giftCard.getBalance());
        
        PaymentReceipt receipt2 = giftCard.pay(order1.getOrderId(), order1.total());
        System.out.println("  Payment made: $" + order1.total());
        System.out.println("  Remaining balance: $" + giftCard.getBalance());
        
        // ============================================
        // Part D - Builder Pattern (CustomDrink)
        // ============================================
        System.out.println("\n--- Part D: Builder Pattern ---");
        
        CustomDrink customDrink = new CustomDrink.Builder()
            .size(Beverage.Size.LARGE)
            .milk(CustomDrink.Milk.OAT)
            .syrup(CustomDrink.Syrup.VANILLA)
            .temperature(CustomDrink.Temperature.ICED)
            .espressoShots(2)
            .addExtra("Whipped Cream")
            .addExtra("Caramel Drizzle")
            .build();
        
        System.out.println("Custom Drink:");
        System.out.println("  Size: " + customDrink.getSize());
        System.out.println("  Milk: " + customDrink.getMilk());
        System.out.println("  Syrup: " + customDrink.getSyrup());
        System.out.println("  Temperature: " + customDrink.getTemperature());
        System.out.println("  Espresso Shots: " + customDrink.getEspressoShots());
        System.out.println("  Extras: " + customDrink.getExtras());
        System.out.println("  Final Price: $" + customDrink.getPrice());
        
        // ============================================
        // Part D - Singleton Pattern (PricingCatalog)
        // ============================================
        System.out.println("\n--- Part D: Singleton Pattern ---");
        
        PricingCatalog catalog = PricingCatalog.getInstance();
        PricingCatalog catalog2 = PricingCatalog.getInstance();
        
        System.out.println("Same instance? " + (catalog == catalog2));
        
        System.out.println("Base price for LATTE: $" + catalog.getBasePrice("LATTE"));
        System.out.println("Base price for COLD_BREW: $" + catalog.getBasePrice("COLD_BREW"));
        System.out.println("Base price for CUSTOM: $" + catalog.getBasePrice("CUSTOM"));
        
        System.out.println("\n=== All tests completed successfully ===");
    }
}