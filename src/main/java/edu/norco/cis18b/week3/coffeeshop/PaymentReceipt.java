package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

/*
 * Represents a receipt produced after a payment is processed.
*/
public record PaymentReceipt
(
        String orderId,
        BigDecimal amount,
        String method,
        Instant timestamp
) {
}