package linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

class CircularLinkedList {
    private Process head; // Head of the circular linked list

    // Process class: Represents a process node in the list
    class Process {
        int processId;
        int burstTime;
        int remainingTime;
        int priority;
        Process next;

        // Constructor to initialize the process
        public Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingTime = burstTime; // Initially remaining time is equal to burst time
            this.priority = priority;
            this.next = null;
        }
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head; // Circular link
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head; // Circular link
        }
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processId) {
        if (head == null) return;

        if (head.processId == processId) {
            Process temp = head;
            if (head.next == head) {
                head = null; // Only one process in the list
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next; // Adjust circular link
                head = head.next; // Move head to next process
            }
            return;
        }

        Process temp = head;
        while (temp.next != head && temp.next.processId != processId) {
            temp = temp.next;
        }
        if (temp.next != head) {
            temp.next = temp.next.next; // Remove the process
        }
    }

    // Simulate the round-robin scheduling of processes
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }

        Process temp = head;
        while (temp != null) {
            int executionTime = Math.min(temp.remainingTime, timeQuantum);
            temp.remainingTime -= executionTime;

            System.out.println("Executing Process ID: " + temp.processId +
                    ", Execution Time: " + executionTime + " units");

            if (temp.remainingTime == 0) {
                System.out.println("Process ID " + temp.processId + " finished execution.");
                removeProcess(temp.processId); // Remove process after execution
            }

            temp = temp.next;
            if (temp == head) break; // Stop if we completed one full cycle
        }
    }

    // Display the processes in the circular queue after each round
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        Process temp = head;
        System.out.println("Current Processes in the Round Robin Queue:");
        do {
            System.out.println("Process ID: " + temp.processId +
                    ", Burst Time: " + temp.burstTime +
                    ", Remaining Time: " + temp.remainingTime +
                    ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head); // Continue displaying in circular order
    }

    // Calculate average waiting time and turn-around time for all processes
    public void calculateAverageTimes() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }

        int totalWaitingTime = 0, totalTurnaroundTime = 0, processCount = 0;
        Process temp = head;
        do {
            int waitingTime = temp.remainingTime - temp.burstTime;
            int turnaroundTime = waitingTime + temp.burstTime;
            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;
            processCount++;
            temp = temp.next;
        } while (temp != head);

        double avgWaitingTime = (double) totalWaitingTime / processCount;
        double avgTurnaroundTime = (double) totalTurnaroundTime / processCount;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}