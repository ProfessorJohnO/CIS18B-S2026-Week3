import java.math.BigDecimal;
import java.time.Instant;

public class CreditCardPayment implements PaymentMethod
{

    private String last4;

    public CreditCardPayment(String last4)
    {

        if (last4 == null || last4.length() != 4)
        {
            throw new IllegalArgumentException("Card digits must be exactly 4 characters");
        }

        this.last4 = last4;
    }

    public PaymentReceipt pay(String orderId, BigDecimal amount)
    {
        String method = "CREDIT_CARD(****" + last4 + ")";

        return new PaymentReceipt
        (
                orderId,
                amount,
                method,
                Instant.now()
        );
    }
}