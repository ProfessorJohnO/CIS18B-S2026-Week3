package edu.norco.cis18b.coffeeshop;
import java.math.BigDecimal;
import java.time.Instant;
record PaymentReceipt(String orderId, BigDecimal amount ,String method, Instant timestamp){}
public interface PaymentMethod {
    PaymentReceipt pay (String orderId, BigDecimal amount);
}