package sortingalgorithms.mergesort;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of book prices
        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        // Example Indian book names
        String[] bookNames = {"Mahabharat", "Ramayan", "Arthashastra", "Bhagavad Gita", "Panchatantra", "Upanishads", "Chanakya Neeti", "Vedas", "Manusmriti", "Yoga Sutras"};

        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            System.out.print(bookNames[i % bookNames.length] + " price: ");
            prices[i] = scanner.nextInt();
        }

        // Creating an object of MergeSort class and sorting the book prices
        MergeSort sorter = new MergeSort();
        sorter.sortBookPrices(prices, 0, n - 1);

        // Displaying sorted book prices
        System.out.println("\nSorted Book Prices in Ascending Order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        scanner.close();
    }
}