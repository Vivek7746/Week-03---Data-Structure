package linkedlist.singlylinkedlist.inventorymanager;

// Primary class: InventoryManager
public class InventoryManager {
    public static void main(String[] args) {
        // Create an instance of the InventoryList
        InventoryList inventory = new InventoryList();

        // Add items to the inventory
        inventory.addAtBeginning("Laptop", 101, 5, 750.00);
        inventory.addAtEnd("Mouse", 102, 10, 25.00);
        inventory.addAtPosition("Keyboard", 103, 8, 50.00, 2);

        // Display all items in the inventory
        System.out.println("All Inventory Items:");
        inventory.display();

        // Search for an item by Item ID
        System.out.println("\nSearching for Item ID 102:");
        inventory.searchById(102);

        // Update the quantity of an item
        System.out.println("\nUpdating quantity for Item ID 101:");
        inventory.updateQuantity(101, 7);
        inventory.display();

        // Calculate total value of inventory
        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());

        // Sort items by price in ascending order
        System.out.println("\nSorting items by Price (Ascending):");
        inventory.sortByPrice(true);
        inventory.display();

        // Remove an item from the inventory
        System.out.println("\nRemoving Item with ID 103:");
        inventory.removeById(103);
        inventory.display();
    }
}
