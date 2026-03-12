package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

/*
 * Represents a gift card payment method that maintains a balance.
*/
public class GiftCardPayment implements PaymentMethod 
{

    private BigDecimal balance;

    /*
     * Constructs a gift card with an initial balance.
     *
     * "InitialBalance" is the starting balance of the gift card
     * - throws IllegalArgumentException if balance is null / negative
    */
    public GiftCardPayment(BigDecimal initialBalance) 
    {

        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) 
        {
            throw new IllegalArgumentException("Initial balance must be non-negative");
        }

        this.balance = initialBalance;
    }

    /*
     * Returns the remaining balance.
    */
    public BigDecimal getBalance() 
    {
        return balance;
    }

    /*
     * Processes a payment using the gift card.
    */
    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) 
    {
        // For invalid entries:
        if (orderId == null || orderId.isBlank()) 
        {
            throw new IllegalArgumentException("Order ID cannot be blank");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) 
        {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (balance.compareTo(amount) < 0) 
        {
            throw new IllegalStateException("Insufficient funds");
        }

        balance = balance.subtract(amount);

        return new PaymentReceipt
        (
                orderId,
                amount,
                "GIFT_CARD",
                Instant.now()
        );
    }
}