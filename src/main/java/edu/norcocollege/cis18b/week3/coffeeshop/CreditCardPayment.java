import java.math.BigDecimal;
import java.time.Instant;

public class CreditCardPayment implements PaymentMethod
{
    private final String last4;

    public CreditCardPayment(String last4)
    {
        if (last4 == null || last4.length() != 4)
        {
            throw new IllegalArgumentException("Last 4 digits must be exactly 4 characters");
        } 
        this.last4 = last4;
    }

    @Override
    public PaymentRecipt pay(String orderId, BigDecimal amount)
    {
        String method = "CREDIT_CARD(****" + last4 + ")";
        return new PaymentRecipt(orderId, amount, method, Instant.now());
    }
}