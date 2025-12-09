public class MaxProductSubarray {
    public static int maxProduct(int[] nums){
        // Time Complexity: O(n), Space Complexity: O(1)
        int prefixProduct = 1, suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            // If either product becomes zero, reset it to 1 to start a new subarray
            // Negative products can still lead to maximum product if multiplied by another negative number later
            prefixProduct = prefixProduct == 0 ? 1 : prefixProduct;
            suffixProduct = suffixProduct == 0 ? 1 : suffixProduct;

            prefixProduct *= nums[i]; // Product from the start
            suffixProduct *= nums[nums.length - 1 - i]; // Product from the end

            // Update the maximum product found so far
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }
        return maxProduct;
    }

    // Brute Force Approach: Check all subarrays, Time Complexity: O(n^2), Space Complexity: O(1)
    public static int maxProductBF(int[] nums){
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int currentProduct = 1;
            for(int j = i; j < n; j++){
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + maxProduct(nums)); // Output: 6

        System.out.println("Maximum Product Subarray (Brute Force): " + maxProductBF(nums)); // Output: 6
    }
}
