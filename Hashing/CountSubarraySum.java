import java.util.HashMap;

public class CountSubarraySum {
    /**
     * Problem: Count the number of subarrays whose sum equals k.
     * 
     * Approach:
     * - Use a HashMap to store the frequency of prefix sums.
     * - For each element, calculate the running prefix sum.
     * - If (prefixSum - k) exists in the map, it means there is a subarray ending at the current index with sum k.
     * - Add the frequency of (prefixSum - k) to the answer.
     * - Update the frequency of the current prefix sum in the map.
     * - Time Complexity: O(n), Space Complexity: O(n)
     */
    private static int subArraySum(int[] nums, int k){
        int n = nums.length, ans = 0, prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // Initialize with prefix sum 0 having frequency 1
        map.put(0, 1);
        for(int i = 0;i<n;i++){
            prefixSum += nums[i];
            int rem = prefixSum - k;

            // If rem exists, add its frequency to answer
            if(map.containsKey(rem)){
                ans += map.get(rem);
            }
            
            // Update the frequency of the current prefix sum
            map.put(prefixSum,map.getOrDefault(prefixSum, 0)+1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int res = subArraySum(arr, 3);
        System.out.println("The no of subarrays found in the array are: "+ res);

    }
}
