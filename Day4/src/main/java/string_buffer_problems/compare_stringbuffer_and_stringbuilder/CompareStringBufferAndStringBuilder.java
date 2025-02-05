package string_buffer_problems.compare_stringbuffer_and_stringbuilder;

public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {

        // Checking StringBuffer execution time
        long SBufferstartTime = System.nanoTime();

        // Declaring a StringBuffer and concatenating thousands of String to it
        StringBuffer stringbuffer = new StringBuffer();

        for(int i = 0; i < 1000000; i++){
            stringbuffer.append("hello");
        }

        long SBufferendTime = System.nanoTime();

        // Displaying execution time of StringBuffer
        System.out.println("Execution time of StringBuffer to concatenate a million strings is " + (SBufferendTime - SBufferstartTime) + " ns");

        // Checking StringBuilder execution time
        long SBuilderstartTime = System.nanoTime();

        // Declaring a StringBuilder and concatenating thousands of String to it
        StringBuilder stringbuilder = new StringBuilder();

        for(int i = 0; i < 1000000; i++){
            stringbuilder.append("hello");
        }

        long SBuilderendTime = System.nanoTime();

        // Displaying execution time of StringBuilder
        System.out.println("Execution time of StringBuilder to concatenate a million strings is " + (SBuilderendTime - SBuilderstartTime) + " ns");
    }
}
