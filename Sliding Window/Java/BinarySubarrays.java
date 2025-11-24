public class BinarySubarrays {
    // Intution: Number of subarrays with sum equal to goal = Number of subarrays with sum at most goal - Number of subarrays with sum at most goal-1
    // Time Complexity: O(N), Space Complexity: O(1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal) - helper(nums,goal - 1);
    }

    private static int helper(int[] nums, int goal){
        int sum = 0, count = 0;

        if(goal < 0)    return 0;

        int l = 0, r = 0;

        while(r < nums.length){
            sum += nums[r];

            while(sum > goal){
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);

            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        BinarySubarrays solution = new BinarySubarrays();
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println("Number of binary subarrays with sum " + goal + ": " + solution.numSubarraysWithSum(nums, goal)); // Output: 4
    }
}
