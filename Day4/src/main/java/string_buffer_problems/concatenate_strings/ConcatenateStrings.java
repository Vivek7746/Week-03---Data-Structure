package string_buffer_problems.concatenate_strings;

public class ConcatenateStrings {

    // Method to Concatenate Strings
    static StringBuffer Concatenate(String[] arrOfStrings){

        // Declaring the resultant StringBuffer
        StringBuffer ConcatenatedString = new StringBuffer();

        // Iterating over the array of strings
        for(int i = 0; i < arrOfStrings.length; i++){

            // Adding current string to the StringBuffer
            ConcatenatedString.append(arrOfStrings[i]);
        }

        // Returning the resultant StringBuffer
        return ConcatenatedString;
    }

    public static void main(String[] args) {

        // Declaring an Array of Strings
        String[] arrOfStrings = {"Ram", "Is", "A", "Student"};

        // Calling Method for Concatenation
        StringBuffer ConcatenatedString = Concatenate(arrOfStrings);

        // Displaying the answer
        System.out.println("The Concatenated String is " + ConcatenatedString);
    }
}