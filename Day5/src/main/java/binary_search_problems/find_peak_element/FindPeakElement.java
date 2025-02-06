package binary_search_problems.find_peak_element;

import static java.lang.System.*;

public class FindPeakElement {

    // Method to find a peak element index in the array
    public static int getPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Prevents overflow

            // If mid element is smaller than the next, move right
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else // Otherwise, move left
                right = mid;
        }
        return left; // Peak element index
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0, 6, 9}; // Example array
        int peakIdx = getPeakElement(arr);
        out.println("Peak element is at index: " + peakIdx);
    }
}