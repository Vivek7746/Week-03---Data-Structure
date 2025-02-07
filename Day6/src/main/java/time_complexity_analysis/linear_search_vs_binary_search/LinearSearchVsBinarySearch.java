package time_complexity_analysis.linear_search_vs_binary_search;

public class LinearSearchVsBinarySearch {

    // Method to check if the target exists linearly
    static boolean linearsearch(int arr[], int target){

        // Iterating over the arr
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }

        // It doesn't exist otherwise
        return false;
    }

    // Method to check if the target exists using binary search
    static boolean binarysearch(int arr[], int target){

        // Declaring high and low
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = (high+low)/2;

            if(arr[mid] == target) return true;
            else if(arr[mid] < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {

        // Creating in array of size 1,000;
        int[] thousand = new int[1000];
        int[] tenthousand = new int[10000];
        int[] million = new int[1000000];

        // putting numbers in the array
        for(int i = 1; i <= 1000; i++){
            thousand[i-1] = i;
        }
        for(int i = 1; i <= 10000; i++){
            tenthousand[i-1] = i;
        }
        for(int i = 1; i <= 1000000; i++){
            million[i-1] = i;
        }

        // Creating two variables to store start and end times
        long starttime, endtime;

        // declaring array to store linear search time
        long[] lineartimes = new long[3];

        // Linear searching on arrays of a Thousand length
        starttime = System.nanoTime();
        boolean exists = linearsearch(thousand, 1000);
        endtime = System.nanoTime();
        lineartimes[0] = endtime - starttime;

        // Linear searching on arrays of Ten thousand length
        starttime = System.nanoTime();
        exists = linearsearch(tenthousand, 10000);
        endtime = System.nanoTime();
        lineartimes[1] = endtime - starttime;

        // Linear searching on arrays of a Million length
        starttime = System.nanoTime();
        exists = linearsearch(million, 1000000);
        endtime = System.nanoTime();
        lineartimes[2] = endtime - starttime;

        // declaring array to store binary search time
        long[] binarytimes = new long[3];

        // Binary searching on arrays of a Thousand length
        starttime = System.nanoTime();
        exists = binarysearch(thousand, 1000);
        endtime = System.nanoTime();
        binarytimes[0] = endtime - starttime;

        // Binary searching on arrays of Ten thousand length
        starttime = System.nanoTime();
        exists = binarysearch(tenthousand, 10000);
        endtime = System.nanoTime();
        binarytimes[1] = endtime - starttime;

        // Binary searching on arrays of a Million length
        starttime = System.nanoTime();
        exists = binarysearch(million, 1000000);
        endtime = System.nanoTime();
        binarytimes[2] = endtime - starttime;

        // Displaying the difference between binary search and linear search
        System.out.printf("-------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s |%n", "Dataset Size(N)", "Linear Search", "Binary Search");
        System.out.printf("-------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s |%n", "1,000", lineartimes[0] + "(ns)", binarytimes[0] + "(ns)");
        System.out.printf("-------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s |%n", "10,000", lineartimes[1] + "(ns)", binarytimes[1] + "(ns)");
        System.out.printf("-------------------------------------------------------%n");
        System.out.printf("| %15s | %15s | %15s |%n", "1,000,000", lineartimes[2] + "(ns)", binarytimes[2] + "(ns)");
        System.out.printf("-------------------------------------------------------%n");
    }
}
