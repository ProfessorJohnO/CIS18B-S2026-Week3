package edu.norco.cis18b.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

public class GiftCardPayment implements PaymentMethod {
    private BigDecimal balance;

    public GiftCardPayment(BigDecimal initialBalance) {
        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("balance must be >= 0");
        }
        this.balance = initialBalance;
    }

    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("amount cannot be null");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("amount cannot be negative");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("insufficient balance");
        }

        balance = balance.subtract(amount);

        return new PaymentReceipt(
                orderId,
                amount,
                "GIFT_CARD",
                Instant.now()
        );
    }

    public BigDecimal getBalance() {
        return balance;
    }
}