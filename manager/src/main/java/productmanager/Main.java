package productmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Electronics");
        Category smartphones = new Category(2, "Smartphones");
        Category accessories = new Category(3, "Accessories");

        List<Product> allProducts = new ArrayList<>();
        Product product1 = new Product(1, "Laptop", 19999.99, "High-performance laptop for work and gaming", electronics);
        Product product2 = new Product(2, "Smartphone", 12999.50, "Smartphone with a large screen and high battery life", smartphones);
        Product product3 = new Product(3, "Headphones", 2499.00, "Wireless headphones with active noise cancellation", accessories);
        
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);

        Cart cart = new Cart();
        List<Order> orderHistory = new ArrayList<>();

        while (true) {
            System.out.println("\n==================================");
            System.out.println("Select an option:");
            System.out.println("1 - View product list");
            System.out.println("2 - Add product to cart by ID");
            System.out.println("3 - Remove product from cart by ID");
            System.out.println("4 - View cart");
            System.out.println("5 - Make an order");
            System.out.println("6 - View order history");
            System.out.println("7 - Search products by name or category");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("\n--- Product List ---");
                    for (Product p : allProducts) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to add: ");
                    int addId = scanner.nextInt();
                    Product foundToAdd = null;
                    for (Product p : allProducts) {
                        if (p.getId() == addId) {
                            foundToAdd = p;
                            break;
                        }
                    }
                    if (foundToAdd != null) {
                        cart.addProduct(foundToAdd);
                        System.out.println("-> '" + foundToAdd.getName() + "' successfully added to your cart!");
                    } else {
                        System.out.println("-> Error: Product with ID " + addId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter product ID to remove from cart: ");
                    int removeId = scanner.nextInt();
                    boolean removed = cart.removeProductById(removeId);
                    if (removed) {
                        System.out.println("-> Product successfully removed from cart.");
                    } else {
                        System.out.println("-> Product with this ID was not found in your cart.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Your Cart ---");
                    System.out.println(cart);
                    break;

                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("\n-> Your cart is empty! Add products before making an order.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.add(order); 
                        System.out.println("\n--- Order Placed Successfully ---");
                        System.out.println(order);
                        cart = new Cart(); 
                    }
                    break;

                case 6:
                    System.out.println("\n--- Order History ---");
                    if (orderHistory.isEmpty()) {
                        System.out.println("No orders made yet.");
                    } else {
                        for (Order ord : orderHistory) {
                            System.out.println(ord);
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter keyword (name or category): ");
                    String keyword = scanner.nextLine().toLowerCase();
                    System.out.println("\n--- Search Results ---");
                    boolean found = false;
                    for (Product p : allProducts) {
                        if (p.getName().toLowerCase().contains(keyword) || 
                            p.getCategory().getName().toLowerCase().contains(keyword)) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No products found matching your request.");
                    }
                    break;

                case 0:
                    System.out.println("\nExiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("\n-> Invalid option. Please try again.");
            }
        }
    }
}