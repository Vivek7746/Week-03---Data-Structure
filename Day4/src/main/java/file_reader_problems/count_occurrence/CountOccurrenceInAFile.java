package file_reader_problems.count_occurrence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.*;

public class CountOccurrenceInAFile {
    public static void main(String[] args) {

        try {
            // Initialising filereader to
            FileReader filereader = new FileReader("TempFile2.txt");
            BufferedReader bufferreader = new BufferedReader(filereader);

            // Initialising String to null
            String string = null;

            String arrOfWords[] = new String[1000];

            // Reading and Printing
            while((string = bufferreader.readLine()) != null){

                System.out.println(string);

                arrOfWords = string.split(" ");
            }

            Map<String, Integer> track = new HashMap<String, Integer>();

            // Traversing over arr of words
            for(String s : arrOfWords){
                if(s != null){
                    if(track.containsKey(s)) {
                        track.put(s, track.get(s) + 1);
                    }
                    else {
                        track.put(s, 1);
                    }
                }
            }

            String is = "is";
            String fruit = "fruit";

            // Displaying the answer
            if(track.containsKey(is)){
                System.out.println(is + " has occured " + track.get(is) + " times in temp file 2");
            }
            else System.out.println(is + " doesn't exist in temp file 2");

            if(track.containsKey(fruit)){
                System.out.println(fruit + " has occured " + track.get(fruit) + " times in temp file 2");
            }
            else System.out.println(fruit + " doesn't exist in temp file 2");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}