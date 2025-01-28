package linkedlist.circularlinkedlist.taskscheduler;

class CircularLinkedList {
    private Task head; // Head node of the circular linked list

    // Task class: Represents a task node in the list
    class Task {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;

        // Constructor for initializing the task
        public Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    // Add a task at the end of the circular linked list
    public void addTask(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Circular link
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head; // Circular link
        }
    }

    // Add a task at a specific position in the circular linked list
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);

        if (position == 1) { // Insert at the beginning
            if (head == null) {
                head = newTask;
                newTask.next = head; // Circular link
            } else {
                Task temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                newTask.next = head;
                head = newTask;
                temp.next = head; // Circular link
            }
            return;
        }

        // Insert at a specific position
        Task temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp != null) {
            newTask.next = temp.next;
            temp.next = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) { // Remove the head task
            Task temp = head;
            if (head.next == head) {
                head = null; // Only one task in the list
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next; // Adjust circular link
                head = head.next; // Move head to next task
            }
            return;
        }

        // Search and remove task by ID
        Task temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next != head) {
            temp.next = temp.next.next; // Remove the task
        }
    }

    // View the current task and move to the next task
    public void viewNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head); // Keep traversing in the circular list
    }

    // Display all tasks in the list
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head); // Keep displaying tasks in circular order
    }

    // Search for tasks by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head); // Keep searching in the circular list
        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}