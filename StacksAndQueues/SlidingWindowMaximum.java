import java.util.Deque;
import java.util.LinkedList;
public class SlidingWindowMaximum {
    // Brute Force Approach
    // Time Complexity: O(n*k)
    // Space Complexity: O(1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for(int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }

    // Optimized Approach using Deque
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    private static int[] maxSlidingWindowOptimized(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // stores indices
        for(int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while(!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove elements smaller than the current element from the deque
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add current element at the back of the deque
            deque.offer(i);
            // The front of the deque is the largest element for the current window
            if(i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = swm.maxSlidingWindow(nums, k);
        System.out.print("Sliding Window Maximums: ");
        for(int num : result) {
            System.out.print(num + " ");
        }

        System.out.println();
        int[] optimizedResult = maxSlidingWindowOptimized(nums, k);
        System.out.print("Optimized Sliding Window Maximums: ");
        for(int num : optimizedResult) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
