package sortingalgorithms.quicksort;

class QuickSort {
    // Method to perform Quick Sort
    public void sortProductPrices(int[] prices, int low, int high) {
        if (low < high) {
            // Partitioning index
            int pi = partition(prices, low, high);

            // Recursively sort elements before and after partition
            sortProductPrices(prices, low, pi - 1);
            sortProductPrices(prices, pi + 1, high);
        }
    }

    private int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot element with the element at (i+1)
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }
}