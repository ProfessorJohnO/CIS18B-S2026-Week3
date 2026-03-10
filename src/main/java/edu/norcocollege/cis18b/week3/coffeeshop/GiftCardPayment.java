
package edu.norco.cis18b.coffeeshop;
import java.math.BigDecimal;
import java.time.Instant;

public class GiftCardPayment implements PaymentMethod 
{

    private BigDecimal balance;

    public GiftCardPayment(BigDecimal initialBalance)
    {

        if(initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Invalid balance");

        balance = initialBalance;
    }

    public PaymentReceipt pay(String orderId, BigDecimal amount)
    {

        if(balance.compareTo(amount) < 0)
            throw new IllegalStateException("Insufficient funds");

        balance = balance.subtract(amount);

        return new PaymentReceipt(
                orderId,
                amount,
                "GIFT_CARD",
                Instant.now()
        );
    }

    public BigDecimal getBalance()
    {
        return balance;
    }
}