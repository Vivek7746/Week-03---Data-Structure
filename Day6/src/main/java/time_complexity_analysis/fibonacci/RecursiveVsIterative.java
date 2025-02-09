package time_complexity_analysis.fibonacci;

public class RecursiveVsIterative {

    // Method to find Fibonacci Resursively
    static long byRecursion(int n){
        if(n == 1) return 1;
        if(n == 0) return 0;

        return byRecursion(n-1) + byRecursion(n-2);
    }

    // Method to find Fibonacci Iteratively
    static long byIteration(int n){
        int a = 0, b = 1;

        long starttime = System.nanoTime();

        for(int i = 3; i <= n; i++){
            int sum = a+b;
            a = b;
            b = sum;
        }

        long endtime = System.nanoTime();

        return (endtime - starttime);
    }

    public static void main(String[] args) {

        // Creating an Array to store Recursive time;
        long[] ResursionTime = new long[3];

        // Finding Fibonacci till 10
        long starttime = System.nanoTime();
        long lastElement = byRecursion(10);
        long endtime = System.nanoTime();
        ResursionTime[0] = endtime-starttime;

        // Finding Fibonacci till 30
        starttime = System.nanoTime();
        lastElement = byRecursion(30);
        endtime = System.nanoTime();
        ResursionTime[1] = endtime-starttime;

        // Finding Fibonacci till 50
        starttime = System.nanoTime();
        lastElement = byRecursion(50);
        endtime = System.nanoTime();
        ResursionTime[1] = endtime-starttime;

        // Displaying results
        System.out.printf("_____________________________________________%n");
        System.out.printf("| %15s | %10s | %10s |%n", "Fibonacci(N)", "Recursive", "Iterative");
        System.out.printf("_____________________________________________%n");
        System.out.printf("| %15s | %10s | %10s |%n", 10, ResursionTime[0], byIteration(10));
        System.out.printf("---------------------------------------------%n");
        System.out.printf("| %15s | %10s | %10s |%n", 30, ResursionTime[1], byIteration(30));
        System.out.printf("---------------------------------------------%n");
        System.out.printf("| %15s | %10s | %10s |%n", 50, ResursionTime[2], byIteration(50));
        System.out.printf("_____________________________________________%n");
    }
}
