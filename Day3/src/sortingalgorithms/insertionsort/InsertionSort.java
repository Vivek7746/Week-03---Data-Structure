package sortingalgorithms.insertionsort;

class InsertionSort {
    // Method to perform Insertion Sort
    public void sortEmployeeIDs(int[] empIDs) {
        int n = empIDs.length;
        for (int i = 1; i < n; i++) {
            int key = empIDs[i];
            int j = i - 1;
            // Move elements of empIDs[0..i-1], that are greater than key,
            // one position ahead of their current position
            while (j >= 0 && empIDs[j] > key) {
                empIDs[j + 1] = empIDs[j];
                j = j - 1;
            }
            empIDs[j + 1] = key;
        }
    }
}