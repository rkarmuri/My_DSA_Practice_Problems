public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 3, 2};
        System.out.println("Single number in array {2, 2, 3, 2} is: " + singleNumber(nums1));

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Single number in array {0, 1, 0, 1, 0, 1, 99} is: " + singleNumberUsingSorting(nums2));

        int[] nums3 = {-2, -2, -3, -2};
        System.out.println("Single number in array {-2, -2, -3, -2} is: " + singleNumberUsingHashing(nums3));
        
        int[] nums4 = {1,1,1,2,2,2,3};
        System.out.println("Single number in array {1,1,1,2,2,2,3} is: " + singleNumberUsingBuckets(nums4));
    }

    private static int singleNumber(int[] nums) {
        // Using bit manipulation
        // Time complexity: O(n*32) where n is the length of the array, 32 is the number of bits in an integer
        // Space complexity: O(1)
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            // Add all bits at ith position for all numbers
            for (int num : nums) {
                sum += (num >> i) & 1; // Check if the ith bit is set
            }
            if (sum % 3 != 0) {
                result |= (1 << i); // Set the ith bit in the result
            }
        }
        return result;
    }

    private static int singleNumberUsingHashing(int[] nums) {
        // Using HashMap to count occurrences
        // Time complexity: O(n) where n is the length of the array
        // Space complexity: O(n) in the worst case if all elements are unique
        java.util.HashMap<Integer, Integer> countMap = new java.util.HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (java.util.Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1; // This line should never be reached
    }

    private static int singleNumberUsingSorting(int[] nums) {
        // Using sorting
        // Time complexity: O(n log n) due to sorting
        // Space complexity: O(1) if in-place sorting is used, otherwise O(n)
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1; // This line should never be reached
    }

    private static int singleNumberUsingBuckets(int[] nums){
        // Using two buckets to track bits appearing once and twice
        // Time complexity: O(n) where n is the length of the array
        // Space complexity: O(1)
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

}
