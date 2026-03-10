
package edu.norco.cis18b.coffeeshop;
import java.math.BigDecimal;
import java.time.Instant;

public class CreditCardPayment implements PaymentMethod 
{

    private String last4;

    public CreditCardPayment(String last4)
    {

        if(last4 == null || last4.length() != 4)
            throw new IllegalArgumentException("Card must be 4 digits");

        this.last4 = last4;
    }

    public PaymentReceipt pay(String orderId, BigDecimal amount)
    {

        return new PaymentReceipt
        (
                orderId,
                amount,
                "CREDIT_CARD(****" + last4 + ")",
                Instant.now()
        );
    }
}