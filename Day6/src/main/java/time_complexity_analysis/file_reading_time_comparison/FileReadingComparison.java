package time_complexity_analysis.file_reading_time_comparison;

import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        // File sizes to test
        String[] fileSizes = {"1MB.txt", "5MB.txt", "50MB.txt"};

        for (String size : fileSizes) {
            String filePath = size; // Modify file paths as needed

            System.out.println("\nTesting with file: " + filePath);

            // Measure time for FileReader (Character Stream)
            long startTime = System.nanoTime();
            readUsingFileReader(filePath);
            long endTime = System.nanoTime();
            System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");

            // Measure time for InputStreamReader (Byte Stream)
            startTime = System.nanoTime();
            readUsingInputStreamReader(filePath);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
        }
    }

    // Read file using FileReader
    private static void readUsingFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read file using InputStreamReader
    private static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {
                // Reading byte by byte and converting to character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}