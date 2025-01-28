package linkedlist.doublylinkedlist.moviemanager;

// Secondary class: MovieList
class MovieList {
    // Node class to represent each movie
    class Node {
        String title;
        String director;
        int year;
        double rating;
        Node next;
        Node prev;

        // Constructor
        public Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Head of the doubly linked list
    private Node tail; // Tail of the doubly linked list

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        Node newNode = new Node(title, director, year, rating);
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
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

    // Remove a movie by title
    public void removeByTitle(String title) {
        Node current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
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
                System.out.println("Movie '" + title + "' removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    // Search for movies by Director
    public void searchByDirector(String director) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + current.title + ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for director '" + director + "'.");
        }
    }

    // Search for movies by Rating
    public void searchByRating(double rating) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating >= rating) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating " + rating + " or higher.");
        }
    }

    // Update a movie's rating
    public void updateRating(String title, double newRating) {
        Node current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie '" + title + "'.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    // Display all movies in forward order
    public void displayForward() {
        Node current = head;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        Node current = tail;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}
