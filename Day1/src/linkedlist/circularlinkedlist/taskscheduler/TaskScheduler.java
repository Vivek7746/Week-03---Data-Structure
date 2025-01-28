package linkedlist.circularlinkedlist.taskscheduler;

public class TaskScheduler {
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList(); // Create circular linked list object

        // Add tasks to the list
        taskList.addTask(1, "Task A", 3, "2025-02-01");
        taskList.addTask(2, "Task B", 1, "2025-02-02");
        taskList.addTask(3, "Task C", 2, "2025-02-03");

        // Display all tasks
        System.out.println("All tasks:");
        taskList.displayTasks();

        // Add task at a specific position (Position 2)
        taskList.addTaskAtPosition(4, "Task D", 5, "2025-02-04", 2);

        // Display all tasks after adding Task D at position 2
        System.out.println("\nTasks after adding Task D:");
        taskList.displayTasks();

        // Remove a task by Task ID (Task B)
        taskList.removeTask(2);

        // Display all tasks after removing Task B
        System.out.println("\nTasks after removing Task B:");
        taskList.displayTasks();

        // View next task in the circular list
        System.out.println("\nViewing tasks:");
        taskList.viewNextTask();

        // Search for tasks with a specific priority (Priority 3)
        System.out.println("\nSearching for tasks with priority 3:");
        taskList.searchByPriority(3);
    }
}