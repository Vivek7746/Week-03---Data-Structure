package binary_search_problems.first_and_last_occurrences;

import static java.lang.System.*;

public class FirstLastOccurance {

    // Method to find the first occurrence of a target in a sorted array
    public static int getFirstOccurance(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid; // Update first occurrence
                right = mid - 1; // Continue searching on the left side
            }
            else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            }
            else {
                right = mid - 1; // Search in the left half
            }
        }
        return first; // Return the first occurrence index, or -1 if not found
    }

    // Method to find the last occurrence of a target in a sorted array
    public static int getLastOccurance(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid; // Update last occurrence
                left = mid + 1; // Continue searching on the right side
            }
            else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            }
            else {
                right = mid - 1; // Search in the left half
            }
        }
        return last; // Return the last occurrence index, or -1 if not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7, 8, 8, 9, 10}; // Example array
        int target = 8;

        // Finding the first and last occurrences of the target
        int res1 = getFirstOccurance(arr, target);
        int res2 = getLastOccurance(arr, target);

        // Output the results
        out.println("First occurrence: " + res1);
        out.println("Last occurrence: " + res2);
    }
}