package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.time.Instant;

public class GiftCardPayment implements PaymentMethod {

    private BigDecimal balance;

    public GiftCardPayment(BigDecimal initialBalance) {
        if (initialBalance == null || initialBalance.compareTo(initialBalance.Zero) < 0) {
            throw new IllegalArgumentException("Initial balance must be => 0");
        }
        this.balance = initialBalance;
    }

    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Insufficient gift card balance");
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