import java.util.List;
import java.util.ArrayList;
class Order{
    String orderId;
    List<MenuItem> items;
    Order(String orderId){
        if (orderId == null ||order.Id.isBlank()) {
                throw new IllegalArgumentException("orderId cannot be null or blank");
        }
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }
}