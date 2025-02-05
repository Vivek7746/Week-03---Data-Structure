package input_stream_reader_problems.byte_to_character_reader;

import java.io.*;

public class ByteToCharacterReader {
    public static void main(String[] args) {
        // Specify the file name (Ensure the file exists in the correct path)
        String fileName = "data.txt";

        // Use try-with-resources to ensure proper resource management
        try (
                // Create a FileInputStream to read the binary data from the file
                FileInputStream fileInputStream = new FileInputStream(fileName);

                // Wrap FileInputStream in InputStreamReader to convert byte stream to character stream
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

                // Use BufferedReader to read the file efficiently
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;

            // Read the file line by line and print the characters to the console
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // Handle case where file is not found
            System.err.println("Error: File not found - " + fileName);
        } catch (IOException e) {
            // Handle input-output exceptions
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}