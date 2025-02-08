package time_complexity_analysis.string_concatenation_analysis;

public class ConcatenationComparison {

    // Method to get total Concatenation time taken by String
    static long byString(String string, int times){

        // Initialising the Resultant String
        String resultant = "";

        // Initialising start time
        long starttime = System.nanoTime();

        // Adding string "times" number of times
        for(int i = 0; i < times; i++){
            resultant += string;
        }

        long endtime = System.nanoTime();

        return (endtime - starttime);
    }

    // Method to get total Concatenation time taken by StringBuilder
    static long byStringBuilder(String string, int times){

        // Initialising the Resultant StringBuilder
        StringBuilder resultant = new StringBuilder();

        // Initialising start time
        long starttime = System.nanoTime();

        // Adding string "times" number of times
        for(int i = 0; i < times; i++){
            resultant.append(string);
        }

        long endtime = System.nanoTime();

        return (endtime - starttime);
    }

    // Method to get total Concatenation time taken by StringBuffer
    static long byStringBuffer(String string, int times){

        // Initialising the Resultant StringBuffer
        StringBuffer resultant = new StringBuffer();

        // Initialising start time
        long starttime = System.nanoTime();

        // Adding string "times" number of times
        for(int i = 0; i < times; i++){
            resultant.append(string);
        }

        long endtime = System.nanoTime();

        return (endtime - starttime);
    }

    public static void main(String[] args) {

        // Initialising a String
        String string = "vivek";

        // Displaying answer
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "Operations", "String", "StringBuilder", "StringBuffer");
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "1,000", byString("vivek", 1000) + "(ns)", byStringBuilder("vivek", 1000) + "(ns)", byStringBuffer("vivek", 1000) + "(ns)");
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "10,000",  byString("vivek", 10000) + "(ns)", byStringBuilder("vivek", 10000) + "(ns)", byStringBuffer("vivek", 10000) + "(ns)");
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s | %15s |%n", "1,00,000", byString("vivek", 100000) + "(ns)", byStringBuilder("vivek", 100000) + "(ns)", byStringBuffer("vivek", 100000) + "(ns)");
        System.out.printf("-------------------------------------------------------------------------%n");
    }
}