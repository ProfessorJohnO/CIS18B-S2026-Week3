package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

public class GiftCardPayment implements PaymentMethod {
    private BigDecimal balance;

    public GiftCardPayment(BigDecimal initialBalance) {
        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance must be >= 0");
        }
        this.balance = initialBalance;
    }

    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or blank");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be null or negative");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance = balance.subtract(amount);
        return new PaymentReceipt(orderId, amount, "GIFT_CARD", Instant.now());
    }

    public BigDecimal getBalance() {
        return balance;
    }
}