package edu.norco.cis18b.week3.coffeeshop;
import java.math.BigDecimal;
import java.time.Instant;
public class CreditCardPayment implements PaymentMethod {
    private String last4;
    public CreditCardPayment(String last4) {
        if (last4 == null || last4.length() != 4) {
            throw new IllegalArgumentException("Last4 must be exactly 4 characters");
        }
        this.last4 = last4;
    }
    @Override
    public PaymentReceipt pay(String orderId, BigDecimal amount) {
        return new PaymentReceipt(
                orderId, amount, "CREDIT_CARD(****" + last4 + ")", Instant.now());
    }
}