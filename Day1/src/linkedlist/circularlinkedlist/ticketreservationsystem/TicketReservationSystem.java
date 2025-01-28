package linkedlist.circularlinkedlist.ticketreservationsystem;

public class TicketReservationSystem {
    public static void main(String[] args) {
        CircularLinkedList reservationSystem = new CircularLinkedList(); // Create circular linked list for reservations

        // Add ticket reservations to the system
        reservationSystem.addTicket(1, "John Doe", "Inception", "A1", "2025-02-01 18:00");
        reservationSystem.addTicket(2, "Jane Smith", "Avatar", "B2", "2025-02-01 19:00");
        reservationSystem.addTicket(3, "Sam Wilson", "Inception", "C3", "2025-02-02 20:00");
        reservationSystem.addTicket(4, "Emily Davis", "The Matrix", "D4", "2025-02-02 21:00");

        // Display all tickets in the system
        System.out.println("Tickets in the reservation system:");
        reservationSystem.displayTickets();

        // Search for a ticket by Customer Name
        System.out.println("\nSearching for tickets by customer name 'John Doe':");
        reservationSystem.searchTicket("John Doe");

        // Search for a ticket by Movie Name
        System.out.println("\nSearching for tickets by movie name 'Inception':");
        reservationSystem.searchTicket("Inception");

        // Remove a ticket by Ticket ID (e.g., ticket ID 2)
        reservationSystem.removeTicket(2);
        System.out.println("\nTickets after removing ticket ID 2:");
        reservationSystem.displayTickets();

        // Calculate total number of booked tickets
        reservationSystem.calculateTotalTickets();
    }
}