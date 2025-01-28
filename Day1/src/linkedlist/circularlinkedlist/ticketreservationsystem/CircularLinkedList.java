package linkedlist.circularlinkedlist.ticketreservationsystem;

class CircularLinkedList {
    private Ticket head; // Head of the circular linked list

    // Ticket class: Represents a ticket node in the list
    class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        // Constructor to initialize a ticket
        public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head; // Circular link
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) return;

        if (head.ticketId == ticketId) { // Remove the head ticket
            Ticket temp = head;
            if (head.next == head) {
                head = null; // Only one ticket in the list
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next; // Adjust circular link
                head = head.next; // Move head to next ticket
            }
            return;
        }

        Ticket temp = head;
        while (temp.next != head && temp.next.ticketId != ticketId) {
            temp = temp.next;
        }
        if (temp.next != head) {
            temp.next = temp.next.next; // Remove the ticket
        }
    }

    // Display all tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        System.out.println("Current Tickets in the Reservation System:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                    ", Customer Name: " + temp.customerName +
                    ", Movie Name: " + temp.movieName +
                    ", Seat Number: " + temp.seatNumber +
                    ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head); // Traverse the list circularly
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchQuery) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchQuery) || temp.movieName.equalsIgnoreCase(searchQuery)) {
                System.out.println("Ticket ID: " + temp.ticketId +
                        ", Customer Name: " + temp.customerName +
                        ", Movie Name: " + temp.movieName +
                        ", Seat Number: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head); // Traverse the list circularly
        if (!found) {
            System.out.println("No tickets found for the given search query.");
        }
    }

    // Calculate and display the total number of booked tickets
    public void calculateTotalTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head); // Traverse the list circularly
        System.out.println("Total Number of Booked Tickets: " + count);
    }
}