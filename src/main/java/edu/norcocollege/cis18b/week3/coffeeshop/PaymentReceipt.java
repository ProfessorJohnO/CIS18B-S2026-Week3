import java.math.BigDecimal;
import java.time.Instant;

public record PaymentRecipt(String orderId, BigDecimal amount, String method, Instant timestamp)
{
    public PaymentRecipt
    {
        if (orderId == null || orderId.isBlank())
        {
            throw new IllegalArgumentException("orderId cannot be null or blank");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        if (method == null || method.isBlank())
        {
            throw new IllegalArgumentException("method cannot be null or blank");
        }
        if (timestamp == null)
        {
            throw new IllegalArgumentException("timestamp cannot be null");
        }
    }
}