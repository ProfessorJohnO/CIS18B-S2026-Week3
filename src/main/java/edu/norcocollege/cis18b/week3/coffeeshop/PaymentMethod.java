import java.math.BigDecimal;

public interface PaymentMethod
{
    PaymentRecipt pay(String orderId, BigDecimal amount);
}