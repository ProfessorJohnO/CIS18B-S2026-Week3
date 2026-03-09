package edu.norco.cis18b.week3.coffeeshop;
import java.math.BigDecimal;
import java.time.Instant;
public class GiftCardPayment implements PaymentMethod {
    private BigDecimal balance;
    public GiftCardPayment(BigDecimal initialBalance) {
        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance must be >= 0");
        }
        this.balance = initialBalance;
    }
    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
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