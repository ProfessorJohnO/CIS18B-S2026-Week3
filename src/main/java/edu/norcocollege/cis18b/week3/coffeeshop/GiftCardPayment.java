import java.math.BigDecimal;
import java.time.Instant;

public class GiftCardPayment implements PaymentMethod
{

    private BigDecimal balance;

    public GiftCardPayment(BigDecimal initialBalance)
    {

        if (initialBalance.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.balance = initialBalance;
    }

    public PaymentReceipt pay(String orderId, BigDecimal amount)
    {
        if (balance.compareTo(amount) < 0)
        {
            throw new IllegalStateException("Insufficient gift card balance");
        }

        balance = balance.subtract(amount);

        return new PaymentReceipt
        (
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