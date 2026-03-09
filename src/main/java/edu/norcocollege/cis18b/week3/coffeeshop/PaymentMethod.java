package edu.norco.cis18b.week3.coffeeshop;
import java.math.BigDecimal;
import java.time.Instant;
record PaymentReceipt(String orderId, BigDecimal amount ,String method, Instant timestamp){}
public interface PaymentMethod {
    PatmentReceipt pay (String orderId, BigDecimal amount);
}