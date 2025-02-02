package sortingalgorithms.selectionsort;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];

        // Example Indian student names
        String[] studentNames = {"Amit", "Priya", "Rahul", "Sneha", "Vikram", "Neha", "Arjun", "Pooja", "Rohan", "Sanya"};

        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            System.out.print(studentNames[i % studentNames.length] + "'s score: ");
            scores[i] = scanner.nextInt();
        }

        // Creating an object of SelectionSort class and sorting the exam scores
        SelectionSort sorter = new SelectionSort();
        sorter.sortExamScores(scores);

        // Displaying sorted exam scores
        System.out.println("\nSorted Exam Scores in Ascending Order:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        scanner.close();
    }
}