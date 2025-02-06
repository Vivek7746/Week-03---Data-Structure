package linear_search_problem.find_a_word_in_sentences;

import java.util.*;
import static java.lang.System.*;

public class SpecificWordz {

    // Method to check if any sentence in the array contains the given word
    public static String havingWordOrNot(String[] a, String word) {
        word = word.toLowerCase(); // Convert search word to lowercase
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i].toLowerCase(); // Convert sentence to lowercase
            if (a[i].contains(word)) // Check if the sentence contains the word
                return a[i]; // Return the matching sentence
        }
        return "Not Found!!!"; // Return if no match is found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] sArray = {"Hello java", "having DSA", "searching by Binary Tree"};

        out.print("Enter word you want to find: ");
        String searchWord = input.next();

        // Display the sentence containing the searched word
        out.println("Given word in Sentences: " + havingWordOrNot(sArray, searchWord));

        input.close(); // Close scanner to prevent resource leak
    }
}