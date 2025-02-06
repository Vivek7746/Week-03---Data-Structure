package linear_search_problem.find_first_negative;

import static java.lang.System.*;
public class FirstNegativeNumber {

    public static int findNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Iterating through the array
            if (arr[i] < 0) // Checking if the current element is negative
                return i; // Returning the index of the first negative number
        }
        return -1; // Returning -1 if no negative number is found
    }

    public static void main(String[] args) {
        // Initializing an array with positive and negative integers
        int[] arr = {5, 2, 9, -3, 1, 4, -1};

        // Calling the method to find the first negative number
        int result = findNegative(arr);

        // Displaying the result
        if (result == -1)
            out.println("There is no negative number in the array");
        else
            out.println("First negative number found in array at the index of: " + result);
    }
}