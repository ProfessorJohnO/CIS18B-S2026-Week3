package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

/*
 * - Represents a credit card payment method.
 * - Stores the last four digits of the card and generates
 * a payment receipt when a payment is processed.
*/
public class CreditCardPayment implements PaymentMethod 
{

    private final String last4;

    /*
     * Constructs a credit card payment using the last four digits.
     *
     * Parameter "last4" is last four digits of the credit card
     * - throws IllegalArgumentException if last4 is null or not exactly 4 digits
    */
    public CreditCardPayment(String last4) 
    {

        if (last4 == null || !last4.matches("\\d{4}")) 
        {
            throw new IllegalArgumentException("Last four digits must be exactly four numeric digits");
        }

        this.last4 = last4;
    }

    /*
     * Processes a payment and returns a PaymentReceipt
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

        return new PaymentReceipt
        (
                orderId,
                amount,
                "CREDIT_CARD(****" + last4 + ")",
                Instant.now()
        );
    }
}