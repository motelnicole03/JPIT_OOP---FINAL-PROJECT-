/**
 * ================================================
 *    JPIT - Jollibee Product Inventory Tracker
 * ================================================
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
