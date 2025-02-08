package time_complexity_analysis.bubble_merge_quick_sort_comparison;
import java.util.*;

public class SortingComparison {

    // ------------------------- Bubble Sort ----------------------------------------------------------------------

    // Method to perform Bubble Sort
    static long bubblesort(int[] OriginalArray){

        // Creating variable to store start time
        long starttime = System.nanoTime();

        // Creating temporary array to perform sorting on
        int[] arr = new int[OriginalArray.length];
        System.arraycopy(OriginalArray, 0, arr, 0, OriginalArray.length);

        // Performing Bubble sort
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // Swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // Creating variable to store end time
        long endtime = System.nanoTime();

        // return total time taken
        return (endtime - starttime);
    }

    // ------------------------- Merge Sort ----------------------------------------------------------------------

    static void actualMerge(int arr[], int l1, int r1, int l2, int r2){

        // Creating a temporary array to store resultant
        int[] temparray = new int[r2-l1+1];

        int track = 0;

        int track2 = l1;

        while(l1 < r1 && l2 < r2){
            if(arr[l1] <= arr[l2]){
                temparray[track] = arr[l1];
                track++;
                l1++;
            }
            else{
                temparray[track] = arr[l2];
                track++;
                l2++;
            }
        }

        while(l1 < r1){
            temparray[track] = arr[l1];
            track++;
            l1++;
        }
        while(l2 < r2){
            temparray[track] = arr[l2];
            track++;
            l2++;
        }

        for(int i = 0; i < temparray.length; i++){
            arr[track2] = temparray[i];
            track2++;
        }
    }

    static void doMergeSort(int arr[], int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;

        doMergeSort(arr, l, mid);
        doMergeSort(arr, mid + 1, r);

        actualMerge(arr, l, mid, mid + 1, r);
    }

    // Method to perform Merge Sort
    static long mergesort(int[] OriginalArray){

        // Variable to store start time and end time
        long starttime = System.nanoTime();

        // Creating temporary array to perform sorting on
        int[] arr = new int[OriginalArray.length];
        System.arraycopy(OriginalArray, 0, arr, 0, OriginalArray.length);

        // Calling Mergesort method
        doMergeSort(arr, 0, arr.length-1);

        long endtime = System.nanoTime();

        return (endtime - starttime);
    }

    // ------------------------- Quick Sort ----------------------------------------------------------------------

    // Partition function
    static int partition(int[] arr, int low, int high) {

        // Choose the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // The QuickSort function implementation
    static void doquickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            doquickSort(arr, low, pi - 1);
            doquickSort(arr, pi + 1, high);
        }
    }

    // Method to perform Quick Sort
    static long quicksort(int[] OriginalArray){

        // Variable to store start time and end time
        long starttime = System.nanoTime();

        // Creating temporary array to perform sorting on
        int[] arr = new int[OriginalArray.length];
        System.arraycopy(OriginalArray, 0, arr, 0, OriginalArray.length);

        // Calling method to perform Quick sort
        doquickSort(arr, 0, arr.length-1);

        long endtime = System.nanoTime();

        return (endtime - starttime);
    }

    public static void main(String[] args) {

        // Creating three Arrays of different sizes
        int[] thousand = new int[1000];
        int[] tenthousand = new int[10000];
        int[] lakh = new int[100000];

        // Putting random values inside the array
        for(int i = 0; i < 1000; i++){
            thousand[i] = (int)(Math.random()*999)+1;
        }
        for(int i = 0; i < 10000; i++){
            tenthousand[i] = (int)(Math.random()*999)+1;
        }
        for(int i = 0; i < 100000; i++){
            lakh[i] = (int)(Math.random()*999)+1;
        }

        // Displaying answer
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "Dataset Size(N)", "Bubble Sort", "Merge Sort", "Quick Sort");
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "1,000", bubblesort(thousand) + "(ns)", mergesort(thousand) + "(ns)", quicksort(thousand) + "(ns)");
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "10,000", bubblesort(tenthousand) + "(ns)", mergesort(tenthousand) + "(ns)", quicksort(tenthousand) + "(ns)");
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "1,00,000", bubblesort(lakh) + "(ns)", mergesort(lakh) + "(ns)", quicksort(lakh) + "(ns)");
        System.out.printf("-------------------------------------------------------------------------%n");

    }
}
