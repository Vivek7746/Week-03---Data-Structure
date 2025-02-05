package input_stream_reader_problems.reading_using_input_stream_reader;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // Specify the output file name
        String fileName = "output.txt";

        // Use try-with-resources to manage resources efficiently
        try (
                // Create an InputStreamReader to read from the console (System.in)
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);

                // Wrap InputStreamReader with BufferedReader for efficient reading
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                // Create a FileWriter to write to the file (append = false to overwrite file each time)
                FileWriter fileWriter = new FileWriter(fileName, false);

                // Wrap FileWriter in BufferedWriter for efficient writing
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            // Read user input line by line until "exit" is entered
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(userInput);
                bufferedWriter.newLine(); // Add a new line after each input
            }

            System.out.println("User input has been saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}