package sortingalgorithms.quicksort;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of products
        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        // Example Indian product names
        String[] productNames = {"Mobile", "Laptop", "Headphones", "Smartwatch", "Charger", "Power Bank", "Camera", "Monitor", "Speaker", "Tablet"};

        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            System.out.print(productNames[i % productNames.length] + " price: ");
            prices[i] = scanner.nextInt();
        }

        // Creating an object of QuickSort class and sorting the product prices
        QuickSort sorter = new QuickSort();
        sorter.sortProductPrices(prices, 0, n - 1);

        // Displaying sorted product prices
        System.out.println("\nSorted Product Prices in Ascending Order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        scanner.close();
    }
}
