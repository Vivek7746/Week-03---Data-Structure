package binary_search_problems.search_in_multidimensional_array;

import static java.lang.System.*;

public class SearchTarget {

    // Method to search a target in a 2D matrix using binary search
    public static boolean searchTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1; // Flatten the 2D matrix to 1D

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid index
            // Convert the 1D mid index to 2D coordinates
            int middleVal = matrix[mid / cols][mid % cols];

            if (middleVal == target) return true; // Target found
            else if (middleVal < target) left = mid + 1; // Search in right half
            else right = mid - 1; // Search in left half
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = { // Example 2D matrix
                {1, 3, 4, 8},
                {10, 12, 16, 20},
                {21, 22, 24, 29} };
        int target = 16;
        out.println("Target found: " + searchTarget(matrix, target)); // Output the result
    }
}