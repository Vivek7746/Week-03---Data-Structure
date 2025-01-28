package linkedlist.singlylinkedlist.inventorymanager;

// Secondary class: InventoryList
class InventoryList {
    // Node class to represent each inventory item
    class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        // Constructor for Node
        public Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private Node head; // Head of the linked list

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add an item at a specific position
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Remove an item by Item ID
    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item ID not found.");
            return;
        }
        current.next = current.next.next;
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search for an item by Item ID
    public void searchById(int itemId) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item Found: ID: " + current.itemId + ", Name: " + current.itemName +
                        ", Quantity: " + current.quantity + ", Price: $" + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Calculate total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        Node current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    // Sort the inventory by price
    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) return; // No sorting needed for empty or single-node list
        head = mergeSortByPrice(head, ascending);
    }

    // Merge sort helper function for price
    private Node mergeSortByPrice(Node head, boolean ascending) {
        if (head == null || head.next == null) return head;
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSortByPrice(head, ascending);
        Node right = mergeSortByPrice(nextOfMiddle, ascending);

        return mergeByPrice(left, right, ascending);
    }

    private Node mergeByPrice(Node left, Node right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        if ((ascending && left.price <= right.price) || (!ascending && left.price >= right.price)) {
            left.next = mergeByPrice(left.next, right, ascending);
            return left;
        } else {
            right.next = mergeByPrice(left, right.next, ascending);
            return right;
        }
    }

    private Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items
    public void display() {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.itemId + ", Name: " + current.itemName +
                    ", Quantity: " + current.quantity + ", Price: $" + current.price);
            current = current.next;
        }
    }
}
