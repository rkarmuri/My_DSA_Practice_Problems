public class CountNiceArrays {

    // Intuition: Number of subarrays with k odd numbers = Number of subarrays with at most k odd numbers - Number of subarrays with at most k-1 odd numbers
    // Time Complexity: O(N), Space Complexity: O(1)
    public int numberOfOddSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private static int helper(int[] nums, int k){
        int n = nums.length, count = 0, r = 0, l = 0, odd = 0;

        if(k < 0)   return 0;

        while(r < n){
            if(nums[r]%2==1)    odd++;

            while(odd > k){
                if(nums[l]%2==1)    odd--;
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountNiceArrays solution = new CountNiceArrays();
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println("Number of nice subarrays: " + solution.numberOfOddSubarrays(nums, k)); // Output: 2
    }
}
