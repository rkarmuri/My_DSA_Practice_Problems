public class KadanesAlgorithm {
    // Time Complexity: O(N), Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
        Long maxi = Long.MIN_VALUE;
        Long sum = 0L;

        for (int num : nums) {
            sum += num;
            maxi = Math.max(maxi, sum);
            if (sum < 0) {
                sum = 0L;
            }
        }
        return maxi.intValue();
    }

    // Extreme Naive Approach (Using Subarrays), Time Complexity: O(N^3), Space Complexity: O(1)
    public int maxSubArrayNaiveExtreme(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    // Better Solution, Time Complexity: O(N^2), Space Complexity: O(1)
    public int maxSubArrayBetter(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        KadanesAlgorithm kadane = new KadanesAlgorithm();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = {-2, -3, -7, -2, -10, -4};
        int[] arr3 = {-1, 2, 3, -1, 2, -6, 5};
        int maxSum = kadane.maxSubArray(arr);
        System.out.println("Maximum Subarray Sum: " + maxSum); // Output: 6

        int maxSumNaiveExtreme = kadane.maxSubArrayNaiveExtreme(arr2);
        System.out.println("Maximum Subarray Sum (Naive Extreme): " + maxSumNaiveExtreme); // Output: -2

        int maxSumBetter = kadane.maxSubArrayBetter(arr3);
        System.out.println("Maximum Subarray Sum (Better): " + maxSumBetter); // Output: 6
    }
}
