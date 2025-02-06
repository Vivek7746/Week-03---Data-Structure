package binary_search_problems.find_rotation_point;

import static java.lang.System.*;
public class FindRotationPoint {

    // Method to find the smallest element (rotation point) in a rotated sorted array
    public static int rotate(int[] a) {
        int len = a.length;
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate mid index

            if (a[mid] > a[right]) // If mid element is greater than the rightmost, search right half
                left = mid + 1;
            else // If mid element is smaller, search left half
                right = mid;
        }
        return a[left]; // The smallest element (rotation point)
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 12, 14, 1, 2}; // Rotated sorted array
        out.println(rotate(arr)); // Output the rotation point (smallest element)
    }
}