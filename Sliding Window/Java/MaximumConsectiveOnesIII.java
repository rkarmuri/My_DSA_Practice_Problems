public class MaximumConsectiveOnesIII {
    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, maxLen = 0, zeroCount = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) { // If condition is optimal over while loop as we need to shrink the window only once
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            r++;
        }

        return maxLen;
    }

    // Brute Force Approach
    private static int longestOnesBruteForce(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                }
                if (zeroCount > k) {
                    break;
                }
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("Maximum consecutive ones after flipping at most " + k + " zeros: " + longestOnes(nums, k)); // Output: 6
        System.out.println("Maximum consecutive ones (Brute Force) after flipping at most " + k + " zeros: " + longestOnesBruteForce(nums, k)); // Output: 6
    }
}
