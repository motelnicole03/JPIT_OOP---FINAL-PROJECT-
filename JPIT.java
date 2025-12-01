/**
 * ================================================
 *    JPIT - Jollibee Product Inventory Tracker
 * ================================================
 *  A Java console-based project using OOP concepts:
 *   -> Encapsulation
 *   -> Inheritance
 *   -> Polymorphism
 *   -> Abstraction
 *
 *  Developed to simulate real-world inventory tracking
 *  for Jollibee menu items.
 * ================================================
 * 
 * 
 */
public class JPIT {
    public static void main(String[] args) {
        System.out.println("Welcome to JPIT!");
        System.out.println("Initializing inventory system...\n");
        
        InventoryManager manager = new InventoryManager();
        manager.seedSampleData();
        manager.run();
        
        System.out.println("\nProgram terminated. Goodbye!");
    }
}