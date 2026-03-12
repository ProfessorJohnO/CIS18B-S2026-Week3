import java.math.BigDecimal;
import java.time.Instant;

public record PaymentReceipt
(
        String orderId,
        BigDecimal amount,
        String method,
        Instant timestamp
) {}

public interface PaymentMethod
{
    PaymentReceipt pay(String orderId, BigDecimal amount);
}