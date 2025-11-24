import java.util.Arrays;

public class ShortestJobFirst {
    // Intution: The process with the shortest burst time is executed first.
    // This reduces the waiting time for the other processes.
    // Approach: Sort the burst times in ascending order and calculate the waiting time.
    // Average waiting time = Total waiting time / Number of processes
    private static long solve(int[] bt){
        // Time complexity: O(n log n)
        // Space complexity: O(1)
        // Total time is the time taken to execute all processes
        // Wait time is the total time a process has to wait before its execution
        int n = bt.length;
        long totalTime = 0, waitTime = 0;

        Arrays.sort(bt);

        for(long time : bt){
            waitTime += totalTime;
            totalTime += time;
        }

        return waitTime/n;
    }

    public static void main(String[] args) {
        int[] bt1 = {6, 8, 7, 3, 4};
        int[] bt2 = {10, 5, 8};

        System.out.println("The average waiting time for bt1 is: " + solve(bt1)); // 13
        System.out.println("The average waiting time for bt2 is: " + solve(bt2)); // 8
    }
}
