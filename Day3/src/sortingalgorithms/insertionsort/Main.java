package sortingalgorithms.insertionsort;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of employees
        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        int[] empIDs = new int[n];

        // Example Indian employee names
        String[] employeeNames = {"Ramesh", "Suresh", "Amit", "Priya", "Rajesh", "Neha", "Anil", "Pooja", "Sunil", "Kiran"};

        System.out.println("Enter the Employee IDs:");
        for (int i = 0; i < n; i++) {
            System.out.print(employeeNames[i % employeeNames.length] + "'s ID: ");
            empIDs[i] = scanner.nextInt();
        }

        // Creating an object of InsertionSort class and sorting the employee IDs
        InsertionSort sorter = new InsertionSort();
        sorter.sortEmployeeIDs(empIDs);

        // Displaying sorted employee IDs
        System.out.println("\nSorted Employee IDs in Ascending Order:");
        for (int id : empIDs) {
            System.out.print(id + " ");
        }
        scanner.close();
    }
}