package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

/*
 * Represents a payment method that processes an order's payment
*/
public interface PaymentMethod 
{
    /*
     * Processes a payment for the given order ID and amount.
     *
     * Parameter: "orderId" | the order being paid for
     * Parameter: "amount" | the payment amount
     * 
     * Return a PaymentReceipt containing the payment details
    */
    PaymentReceipt pay(String orderId, BigDecimal amount);
}