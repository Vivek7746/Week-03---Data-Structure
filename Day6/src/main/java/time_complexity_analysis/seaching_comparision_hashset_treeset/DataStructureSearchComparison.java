package time_complexity_analysis.seaching_comparision_hashset_treeset;

import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        // Different values of N to test
        int[] sizes = {1000, 10000, 1000000};

        for (int N : sizes) {
            System.out.println("\nTesting for N = " + N);

            // Generate N random integers
            Random random = new Random();
            int[] array = new int[N];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < N; i++) {
                int num = random.nextInt(N * 10); // Avoid duplicates as much as possible
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            // Choose a random element to search
            int target = array[random.nextInt(N)];

            // Measure search time in Array (Linear Search)
            long startTime = System.nanoTime();
            boolean foundInArray = linearSearch(array, target);
            long endTime = System.nanoTime();
            System.out.println("Array search time (O(N)): " + (endTime - startTime) + " ns");

            // Measure search time in HashSet (O(1) on average)
            startTime = System.nanoTime();
            boolean foundInHashSet = hashSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("HashSet search time (O(1)): " + (endTime - startTime) + " ns");

            // Measure search time in TreeSet (O(log N))
            startTime = System.nanoTime();
            boolean foundInTreeSet = treeSet.contains(target);
            endTime = System.nanoTime();
            System.out.println("TreeSet search time (O(log N)): " + (endTime - startTime) + " ns");
        }
    }

    // Linear search for Array
    private static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}