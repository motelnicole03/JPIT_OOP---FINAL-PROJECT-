/**
 * FoodItem subclass representing food products.
 * Demonstrates Inheritance and Polymorphism.
 */
public class FoodItem extends Product {
    private boolean spicy;
    private String size;

    public FoodItem(String sku, String name, double price, int quantity, 
                    boolean spicy, String size) {
        super(sku, name, price, quantity);
        this.spicy = spicy;
        this.size = size;
    }

    public boolean isSpicy() { 
        return spicy; 
    }
    
    public void setSpicy(boolean spicy) { 
        this.spicy = spicy; 
    }

    public String getSize() { 
        return size; 
    }
    
    public void setSize(String size) { 
        this.size = size; 
    }

    @Override
    public void displayDetails() {
        System.out.printf("""
                          
                           [FOOD ITEM]
                            SKU: %s
                            Name: %s (%s)
                            Price: P%.2f
                            Quantity: %d
                            Spicy: %s
                          """,
            getSku(), getName(), size, getPrice(), 
            getQuantity(), spicy ? "Yes" : "No"
        );
    }

    @Override
    public double applyDiscount(double percentage) {
        // Maximum 50% discount for food items
        double discount = Math.min(percentage, 50.0);
        double newPrice = getPrice() * (1 - discount / 100.0);
        setPrice(newPrice);
        return newPrice;
    }
}