package string_builder_problems.reverse_a_string;

public class reverseString {

    // Method to reverse a String using String Builder

    public static String reverseit(String string) {
        // Creating a String Builder
        StringBuilder string_builder = new StringBuilder(string);

        // using Reverse method
        StringBuilder reversed_string_builder = string_builder.reverse();

        // Converting reversed String builder to a String
        String reversed_string = reversed_string_builder.toString();

        // Returning the resultant string
        return reversed_string;
    }
}
