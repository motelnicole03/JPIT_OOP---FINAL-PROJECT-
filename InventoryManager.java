import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Core inventory management system.
 * Handles all CRUD operations and user interactions.
 */
public class InventoryManager {
    private List<Product> products;
    private Scanner scanner;

    public InventoryManager() {
        this.products = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Seeds initial sample data for demonstration
     */
    public void seedSampleData() {
        products.add(new FoodItem("F001", "Chickenjoy (Piece)", 89.00, 30, false, "Regular"));
        products.add(new FoodItem("F002", "Jolly Spaghetti", 69.00, 20, false, "Regular"));
        products.add(new FoodItem("F003", "Burger Steak", 75.00, 15, false, "Regular"));
        products.add(new DrinkItem("D001", "Coke (Can)", 30.00, 50, true, 330));
        products.add(new DrinkItem("D002", "Iced Tea", 35.00, 25, true, 350));
    }

    /**
     * Main program loop
     */
    public void run() {
        boolean exit = false;
        while (!exit) {
            printHeader();
            printMenu();

            int choice = safeIntInput("\n Choose an option: ");
            System.out.println();

            switch (choice) {
                case 1 -> displayAll();
                case 2 -> addProduct();
                case 3 -> removeProduct();
                case 4 -> updateQuantity();
                case 5 -> searchProduct();
                case 6 -> applyDiscountToProduct();
                case 7 -> restockLowItems();
                case 8 -> displaySummary();
                case 0 -> {
                    System.out.println("\nExiting JPIT. Thank you and have a Jolli day!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            
            if (!exit) {
                pause();
            }
        }
        scanner.close();
    }

    private void printHeader() {
        System.out.println("\n================================================");
        System.out.println("      JOLLIBEE PRODUCT INVENTORY TRACKER ");
        System.out.println("================================================");
    }

    private void printMenu() {
        System.out.println("\n[1] Display All Products");
        System.out.println("[2] Add New Product");
        System.out.println("[3] Remove Product by SKU");
        System.out.println("[4] Update Product Quantity");
        System.out.println("[5] Search Product");
        System.out.println("[6] Apply Discount");
        System.out.println("[7] Auto Restock Low Items");
        System.out.println("[8] Show Inventory Summary");
        System.out.println("[0] Exit Program");
    }

    // ==========================================
    // Display Methods
    // ==========================================
    
    private void displayAll() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        System.out.println("\nCURRENT PRODUCTS IN STOCK:");
        System.out.println("============================================");
        for (Product p : products) {
            p.displayDetails();
        }
    }

    private void addProduct() {
        System.out.println("\nADD NEW PRODUCT");
        System.out.println("--------------------");
        System.out.println("1) Food Item");
        System.out.println("2) Drink Item");
        int type = safeIntInput("Enter type: ");

        String sku = safeStringInput("SKU: ");
        if (findBySku(sku) != null) {
            System.out.println("SKU already exists.");
            return;
        }

        String name = safeStringInput("Name: ");
        double price = safeDoubleInput("Price (P): ");
        int qty = safeIntInput("Quantity: ");

        if (type == 1) {
            boolean spicy = safeBooleanInput("Spicy? (y/n): ");
            String size = safeStringInput("Size (Regular/Large): ");
            products.add(new FoodItem(sku, name, price, qty, spicy, size));
        } else if (type == 2) {
            boolean cold = safeBooleanInput("Cold? (y/n): ");
            int ml = safeIntInput("Volume (ml): ");
            products.add(new DrinkItem(sku, name, price, qty, cold, ml));
        } else {
            System.out.println("Invalid type.");
            return;
        }

        System.out.println("Product added successfully!");
    }

    private void removeProduct() {
        String sku = safeStringInput("\nEnter SKU to remove: ");
        Product p = findBySku(sku);
        if (p == null) {
            System.out.println("Product not found.");
            return;
        }
        products.remove(p);
        System.out.println("Removed product: " + p.getName());
    }

    private void updateQuantity() {
        String sku = safeStringInput("\nEnter SKU: ");
        Product p = findBySku(sku);
        if (p == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("\nCurrent quantity: " + p.getQuantity());
        System.out.println("1) Consume (Sell)");
        System.out.println("2) Restock");
        int choice = safeIntInput("Choice: ");

        if (choice == 1) {
            int amount = safeIntInput("Amount to sell: ");
            if (p.consume(amount)) {
                System.out.println("Sold! New quantity: " + p.getQuantity());
            } else {
                System.out.println("Not enough stock.");
            }
        } else if (choice == 2) {
            int amount = safeIntInput("Amount to restock: ");
            p.restock(amount);
            System.out.println("Restocked! New quantity: " + p.getQuantity());
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void searchProduct() {
        String query = safeStringInput("\nEnter name or SKU to search: ");
        List<Product> found = new ArrayList<>();
        
        for (Product p : products) {
            if (p.getSku().equalsIgnoreCase(query) || 
                p.getName().toLowerCase().contains(query.toLowerCase())) {
                found.add(p);
            }
        }
        
        if (found.isEmpty()) {
            System.out.println("No matching products found.");
            return;
        }

        System.out.println("\nSEARCH RESULTS:");
        System.out.println("============================================");
        for (Product p : found) {
            p.displayDetails();
        }
    }

    private void applyDiscountToProduct() {
        String sku = safeStringInput("\nEnter SKU to discount: ");
        Product p = findBySku(sku);
        if (p == null) {
            System.out.println("Product not found.");
            return;
        }
        
        System.out.printf("Current price: P%.2f\n", p.getPrice());
        double pct = safeDoubleInput("Discount %: ");
        double newPrice = p.applyDiscount(pct);
        System.out.printf("Discount applied! New price: P%.2f\n", newPrice);
    }

    private void restockLowItems() {
        int threshold = safeIntInput("\nRestock items with qty <=: ");
        int restockAmount = safeIntInput("Restock each by: ");

        int count = 0;
        System.out.println("\nRestocking...");
        for (Product p : products) {
            if (p.getQuantity() <= threshold) {
                p.restock(restockAmount);
                System.out.printf("  %s: %d -> %d\n", 
                    p.getName(), 
                    p.getQuantity() - restockAmount, 
                    p.getQuantity());
                count++;
            }
        }
        System.out.println("Restocked " + count + " item(s)!");
    }

    private void displaySummary() {
        int totalItems = products.size();
        int totalQty = products.stream()
            .mapToInt(Product::getQuantity)
            .sum();
        double totalValue = products.stream()
            .mapToDouble(p -> p.getPrice() * p.getQuantity())
            .sum();

        System.out.println("\nINVENTORY SUMMARY");
        System.out.println("============================================");
        System.out.println("Total Distinct Products: " + totalItems);
        System.out.println("Total Quantity in Stock: " + totalQty);
        System.out.printf("Total Inventory Value:   P%.2f\n", totalValue);
        System.out.println("============================================");
    }

    // ==========================================
    // Utility Methods
    // ==========================================
    
    private Product findBySku(String sku) {
        for (Product p : products) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null;
    }

    private void pause() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    // ==========================================
    // Safe Input Methods
    // ==========================================
    
    private int safeIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    private double safeDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private String safeStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private boolean safeBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String in = scanner.nextLine().trim().toLowerCase();
            if (in.equals("y") || in.equals("yes")) {
                return true;
            }
            if (in.equals("n") || in.equals("no")) {
                return false;
            }
            System.out.println("Enter only y/n.");
        }
    }
}