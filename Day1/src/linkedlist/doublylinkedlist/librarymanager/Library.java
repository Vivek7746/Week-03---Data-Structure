package linkedlist.doublylinkedlist.librarymanager;

// Secondary class: Library
class Library {
    // Node class to represent each book
    class Node {
        String title;
        String author;
        String genre;
        int bookID;
        boolean availability;
        Node next;
        Node prev;

        // Constructor
        public Node(String title, String author, String genre, int bookID, boolean availability) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookID = bookID;
            this.availability = availability;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Head of the doubly linked list
    private Node tail; // Tail of the doubly linked list

    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookID, boolean availability) {
        Node newNode = new Node(title, author, genre, bookID, availability);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a book at the end
    public void addAtEnd(String title, String author, String genre, int bookID, boolean availability) {
        Node newNode = new Node(title, author, genre, bookID, availability);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a book at a specific position
    public void addAtPosition(String title, String author, String genre, int bookID, boolean availability, int position) {
        Node newNode = new Node(title, author, genre, bookID, availability);
        if (position == 1) {
            addAtBeginning(title, author, genre, bookID, availability);
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
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        newNode.prev = current;
        current.next = newNode;
    }

    // Remove a book by Book ID
    public void removeByBookID(int bookID) {
        Node current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Book with ID " + bookID + " removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Search for a book by Title
    public void searchByTitle(String title) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: Title: " + current.title + ", Author: " + current.author +
                        ", Genre: " + current.genre + ", Book ID: " + current.bookID +
                        ", Available: " + current.availability);
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    // Search for books by Author
    public void searchByAuthor(String author) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: Title: " + current.title + ", Genre: " + current.genre +
                        ", Book ID: " + current.bookID + ", Available: " + current.availability);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found by author '" + author + "'.");
        }
    }

    // Update a book's Availability Status
    public void updateAvailability(int bookID, boolean availability) {
        Node current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.availability = availability;
                System.out.println("Availability status updated for Book ID " + bookID + ".");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        Node current = head;
        if (current == null) {
            System.out.println("No books in the library.");
            return;
        }
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookID + ", Available: " + current.availability);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        Node current = tail;
        if (current == null) {
            System.out.println("No books in the library.");
            return;
        }
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookID + ", Available: " + current.availability);
            current = current.prev;
        }
    }

    // Count total number of books
    public int countBooks() {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}