package productmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private static int counter = 1;
    private int orderId = counter++;
    private Cart cart;
    private String status = "Created";

    public Order(Cart cart) {
        this.cart = cart;
    }
}