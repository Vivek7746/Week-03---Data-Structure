package linkedlist.doublylinkedlist.texteditor;

// Secondary Class: UndoRedoManager
class UndoRedoManager {
    // Node class to represent a state
    class Node {
        String textState;
        Node next;
        Node prev;

        // Constructor
        public Node(String textState) {
            this.textState = textState;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;   // Head of the doubly linked list
    private Node tail;   // Tail of the doubly linked list
    private Node current; // Pointer to the current state
    private int maxSize;  // Maximum history size
    private int size;     // Current size of the history

    // Constructor
    public UndoRedoManager(int maxSize) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.maxSize = maxSize;
        this.size = 0;
    }

    // Add a new state
    public void addState(String newText) {
        Node newNode = new Node(newText);

        // If we're not at the tail, remove all future states (truncate redo history)
        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
        }

        // Add new state to the end
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        current = newNode;

        // Increment size and enforce history limit
        size++;
        if (size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Undo not possible. Already at the oldest state.");
            return;
        }
        current = current.prev;
    }

    // Redo functionality
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Redo not possible. Already at the newest state.");
            return;
        }
        current = current.next;
    }

    // Display the current state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No state available.");
        } else {
            System.out.println("Current State: " + current.textState);
        }
    }
}