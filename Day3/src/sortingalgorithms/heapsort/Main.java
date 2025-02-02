package sortingalgorithms.heapsort;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of job applicants
        System.out.print("Enter number of job applicants: ");
        int n = scanner.nextInt();
        int[] salaries = new int[n];

        // Example Indian applicant names
        String[] applicantNames = {"Rajesh", "Anjali", "Vikas", "Meera", "Sandeep", "Nisha", "Arun", "Pooja", "Rohan", "Simran"};

        System.out.println("Enter the expected salary demands:");
        for (int i = 0; i < n; i++) {
            System.out.print(applicantNames[i % applicantNames.length] + "'s expected salary: ");
            salaries[i] = scanner.nextInt();
        }

        // Creating an object of HeapSort class and sorting the salary demands
        HeapSort sorter = new HeapSort();
        sorter.sortSalaries(salaries);

        // Displaying sorted salary demands
        System.out.println("\nSorted Salary Demands in Ascending Order:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        scanner.close();
    }
}
