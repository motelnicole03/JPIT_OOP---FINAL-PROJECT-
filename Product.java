/**
 * Abstract base class for all products in the inventory system.
 * Demonstrates Abstraction and Encapsulation principles.
 */
public abstract class Product {
    private String sku;
    private String name;
    private double price;
    private int quantity;

    public Product(String sku, String name, double price, int quantity) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters (Encapsulation)
    public String getSku() { 
        return sku; 
    }
    
    public void setSku(String sku) { 
        this.sku = sku; 
    }

    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }

    public double getPrice() { 
        return price; 
    }
    
    public void setPrice(double price) { 
        this.price = price; 
    }

    public int getQuantity() { 
        return quantity; 
    }
    
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    public boolean isAvailable() { 
        return quantity > 0; 
    }

    // Abstract Methods (Abstraction)
    public abstract void displayDetails();
    public abstract double applyDiscount(double percentage);

    /**
     * Adds stock to the product inventory
     * @param amount The amount to add
     */
    public void restock(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    /**
     * Consumes (sells) product from inventory
     * @param amount The amount to consume
     * @return true if successful, false if insufficient stock
     */
    public boolean consume(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount <= quantity) {
            quantity -= amount;
            return true;
        }
        return false;
    }
}