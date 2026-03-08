import java.util.List;
import java.util.ArrayList;
class Order{
    String orderId;
    List<MenuItem> items;
    Order(String orderId){
        if (orderId == null ||order.Id.isBlank()) {
                throw new IllegalArgumentException("Price must be greater than or equal to zero");
        }
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }
}