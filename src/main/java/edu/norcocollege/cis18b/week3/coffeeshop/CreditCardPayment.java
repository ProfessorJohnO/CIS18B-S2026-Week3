package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

public class CreditCardPayment implements PaymentMethod {

    private final String last4;

    public CreditCardPayment(String last4) {
        if (last4 == null || last4.length() != ) {
            throw new IllegalArgumentException("last 4 must be exactly 4 characters");
        }
        this.last4 = last4;
    }

    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        String method = "CREDIC_CARD(****" + last4 + ")";
        return new PaymentReceipt(orderId, amount, method, Instant.now());
    }     
}