package linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        CircularLinkedList processList = new CircularLinkedList(); // Create circular linked list for processes

        // Add processes to the list (Process ID, Burst Time, Priority)
        processList.addProcess(1, 5, 1);
        processList.addProcess(2, 8, 2);
        processList.addProcess(3, 3, 3);
        processList.addProcess(4, 6, 4);

        // Display the list of processes before scheduling
        System.out.println("Processes before round-robin scheduling:");
        processList.displayProcesses();

        // Simulate the round-robin scheduling with a fixed time quantum (e.g., 4 units)
        int timeQuantum = 4;
        processList.roundRobinScheduling(timeQuantum);

        // Display the list of remaining processes
        System.out.println("\nRemaining processes after round-robin scheduling:");
        processList.displayProcesses();

        // Calculate and display average waiting time and turn-around time for all processes
        processList.calculateAverageTimes();
    }
}