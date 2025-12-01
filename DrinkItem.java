/**
 * DrinkItem subclass representing beverage products.
 * Demonstrates Inheritance and Polymorphism.
 */
public class DrinkItem extends Product {
    private boolean cold;
    private int ml;

    public DrinkItem(String sku, String name, double price, int quantity, 
                     boolean cold, int ml) {
        super(sku, name, price, quantity);
        this.cold = cold;
        this.ml = ml;
    }

    public boolean isCold() { 
        return cold; 
    }
    
    public void setCold(boolean cold) { 
        this.cold = cold; 
    }

    public int getMl() { 
        return ml; 
    }
    
    public void setMl(int ml) { 
        this.ml = ml; 
    }

    @Override
    public void displayDetails() {
        System.out.printf("""
                          
                           [DRINK ITEM]
                            SKU: %s
                            Name: %s (%dml)
                            Price: P%.2f
                            Quantity: %d
                            Cold: %s
                          """,
            getSku(), getName(), ml, getPrice(), 
            getQuantity(), cold ? "Yes" : "No"
        );
    }

    @Override
    public double applyDiscount(double percentage) {
        // Maximum 70% discount for drinks
        double discount = Math.min(percentage, 70.0);
        double newPrice = getPrice() * (1 - discount / 100.0);
        setPrice(newPrice);
        return newPrice;
    }
}