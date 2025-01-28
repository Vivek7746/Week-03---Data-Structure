package linkedlist.doublylinkedlist.librarymanager;

// Primary class: LibraryManager
public class LibraryManager {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addAtPosition("1984", "George Orwell", "Dystopian", 103, false, 2);

        // Display books in forward order
        System.out.println("Books in Forward Order:");
        library.displayForward();

        // Display books in reverse order
        System.out.println("\nBooks in Reverse Order:");
        library.displayReverse();

        // Search for a book by Title
        System.out.println("\nSearch for book titled '1984':");
        library.searchByTitle("1984");

        // Search for books by Author
        System.out.println("\nSearch for books by 'Harper Lee':");
        library.searchByAuthor("Harper Lee");

        // Update a book's Availability Status
        System.out.println("\nUpdating availability status of '1984':");
        library.updateAvailability(103, true);
        library.displayForward();

        // Remove a book by Book ID
        System.out.println("\nRemoving the book with Book ID 101:");
        library.removeByBookID(101);
        library.displayForward();

        // Count total books
        System.out.println("\nTotal number of books in the library: " + library.countBooks());
    }
}
