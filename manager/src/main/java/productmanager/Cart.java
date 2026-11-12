package productmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProductById(int productId) {
        return products.removeIf(p -> p.getId() == productId);
    }

    public double getTotalPrice() {
        double total = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        return Math.round(total);
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return "Cart is empty.";
        }
        StringBuilder sb = new StringBuilder("Cart contents:\n");
        for (Product p : products) {
            sb.append(" - ").append(p).append("\n");
        }
        sb.append("Total price: ").append(getTotalPrice());
        return sb.toString();
    }
}