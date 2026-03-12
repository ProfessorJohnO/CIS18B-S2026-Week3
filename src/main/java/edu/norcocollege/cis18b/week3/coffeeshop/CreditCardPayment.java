package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

public class CreditCardPayment implements PaymentMethod {
    private final String last4;

    public CreditCardPayment(String last4) {
        if (last4 == null || last4.length() != 4) {
            throw new IllegalArgumentException("Last 4 digits must be exactly 4 characters");
        }
        this.last4 = last4;
    }

    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or blank");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be null or negative");
        }
        String method = "CREDIT_CARD(****" + last4 + ")";
        return new PaymentReceipt(orderId, amount, method, Instant.now());
    }
}