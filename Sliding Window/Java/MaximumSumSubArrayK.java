/* Problem: Given an array of integers and a number k, find the maximum sum of a subarray of size k. */

import java.util.Map;
import java.util.HashMap;

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

    // For K distinct elements
    public long maxSumSubArrayKDistinct(int[] arr, int k) {
        int n = arr.length, left = 0;
        long maxSum = 0, windowSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < n; right++) {
            windowSum += arr[right];
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            if(right - left + 1 > k) {
                windowSum -= arr[left];
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if(freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++;
            }

            if(right - left + 1 == k && freqMap.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumSubArrayK solution = new MaximumSumSubArrayK();
        int[] arr = {2, 1, 5, 1, 3, 2};
        int[] arrDistinct = {1, 5, 4, 2, 9, 9, 9, 3, 5, 1, 4};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + solution.maxSumSubArrayK(arr, k)); // Output: 9
        System.out.println("Maximum sum of subarray of size " + k + " (Brute Force): " + solution.maxSumSubArrayKBruteForce(arr, k)); // Output: 9
        System.out.println("Maximum sum of subarray of size " + k + " with distinct elements: " + solution.maxSumSubArrayKDistinct(arrDistinct, k)); // Output: 15
    }
}
