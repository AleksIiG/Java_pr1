package productmanager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    @Override
    public String toString() {
        return "Product{id=" + id + 
                ", name='" + name + '\'' + 
                ", price=" + price + 
                ", description='" + description + '\'' + 
                ", category='" + (category != null ? category.getName() : "N/A") + "'}";
    }
}