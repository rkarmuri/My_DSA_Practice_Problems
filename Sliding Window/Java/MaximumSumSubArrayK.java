public class MaximumSumSubArrayK {
    // Time Complexity: O(N), Space Complexity: O(1)
    public int maxSumSubArrayK(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            return -1; // Not enough elements
        }

        int maxSum = 0;
        int windowSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window from start to end
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element and remove the first element of the previous window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Brute Force Approach for comparison
    public int maxSumSubArrayKBruteForce(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            return -1; // Not enough elements
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int currentSum = 0, j = i;
            while (j < i + k) {
                currentSum += arr[j];
                j++;
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumSubArrayK solution = new MaximumSumSubArrayK();
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + solution.maxSumSubArrayK(arr, k)); // Output: 9
        System.out.println("Maximum sum of subarray of size " + k + " (Brute Force): " + solution.maxSumSubArrayKBruteForce(arr, k)); // Output: 9
    }
}
