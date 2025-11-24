public class MinimumPlatforms {
    // Intution: We need to find the maximum number of trains that overlap at any point in time.
    // We can achieve this by sorting the arrival and departure times separately and then using two pointers
    // to traverse through both arrays. We increment the platform count when a train arrives and decrement
    // it when a train departs. The maximum value of the platform count during this traversal
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arrival.length;

        System.out.println("Minimum number of platforms required: " + findMinimumPlatforms(arrival, departure, n));
    }

    public static int findMinimumPlatforms(int[] arrival, int[] departure, int n) {
        // Time Complexity: O(2*(n log n + n)) => O(n log n)
        // Space Complexity: O(1)
        java.util.Arrays.sort(arrival);
        java.util.Arrays.sort(departure);

        int platformNeeded = 1, result = 1;
        int i = 1, j = 0; // i is 1 because we have already considered the first train's arrival

        while(i < n && j < n) {
            if(arrival[i] <= departure[j]) {
                platformNeeded++;
                i++;
            } else {
                platformNeeded--;
                j++;
            }
            result = Math.max(result, platformNeeded);
        }
        return result;
    }
}
