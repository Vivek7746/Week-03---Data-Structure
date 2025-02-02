package sortingalgorithms.countingsort;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];

        // Example Indian student names
        String[] studentNames = {"Amit", "Priya", "Rahul", "Sneha", "Vikram", "Neha", "Arjun", "Pooja", "Rohan", "Sanya"};

        System.out.println("Enter the students' ages (10-18 years):");
        for (int i = 0; i < n; i++) {
            System.out.print(studentNames[i % studentNames.length] + "'s age: ");
            ages[i] = scanner.nextInt();

            // Validate age input
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age! Please enter an age between 10 and 18.");
                i--; // Retry the input
            }
        }

        // Creating an object of CountingSort class and sorting the ages
        CountingSort sorter = new CountingSort();
        sorter.sortAges(ages);

        // Displaying sorted ages
        System.out.println("\nSorted Student Ages in Ascending Order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        scanner.close();
    }
}