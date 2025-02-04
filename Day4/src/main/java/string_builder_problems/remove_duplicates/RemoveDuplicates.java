package string_builder_problems.remove_duplicates;

import java.util.HashSet;

public class RemoveDuplicates {

    // Method to remove duplicates from the string
    public static String removingDuplicates(String string){

        // Creating a HashSet to keep track
        HashSet<Character> trackchar = new HashSet<>();

        // Initialising a StringBuilder to store unique elements
        StringBuilder resultantstring = new StringBuilder();

        // Iterating over the string
        for(int i = 0; i < string.length(); i++){

            // if the character is already present inside the hashmap
            if(trackchar.contains(string.charAt(i))) {
                // this is not a unique character
            }
            // else we will add it to our answer
            else {
                resultantstring.append(string.charAt(i));
                trackchar.add(string.charAt(i));
            }
        }

        // Returning the Resultant String
        return resultantstring.toString();
    }

    // Driver function
    public static void main(String[] args) {

        // Initialising a String
        String string = "vivek";

        String string_without_duplicates = removingDuplicates(string);

        // Displaying the result
        System.out.println("Before, String : " + string);
        System.out.println("After, String : " + string_without_duplicates);
    }
}
