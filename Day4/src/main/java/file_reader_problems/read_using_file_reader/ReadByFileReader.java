package file_reader_problems.read_using_file_reader;

import java.io.*;

public class ReadByFileReader {
    public static void main(String[] args) {

        try {
            // Initialising filereader to
            FileReader filereader = new FileReader("TempFile.txt");
            BufferedReader bufferreader = new BufferedReader(filereader);

            // Initialising String to null
            String string = null;

            // Reading and Printing
            while((string = bufferreader.readLine()) != null){
                System.out.println(string);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}