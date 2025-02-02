package sortingalgorithms.bubblesort;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];

        // Example Indian student names
        String[] studentNames = {"Amit", "Priya", "Rahul", "Sneha", "Vikram", "Neha", "Arjun", "Pooja", "Rohan", "Sanya"};

        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            System.out.print(studentNames[i % studentNames.length] + "'s marks: ");
            marks[i] = scanner.nextInt();
        }

        // Creating an object of BubbleSort class and sorting the marks
        BubbleSort sorter = new BubbleSort();
        sorter.sortMarks(marks);

        // Displaying sorted marks
        System.out.println("\nSorted Marks in Ascending Order:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        scanner.close();
    }
}
