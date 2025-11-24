import java.util.HashMap;

public class LongestSubarraySum {
    /**
     * Problem: Find the length of the longest subarray with sum equal to k.
     * Approach:
     * - Use a HashMap to store the first occurrence of each prefix sum.
     * - For each index, calculate the prefix sum.
     * - If prefix sum equals k, update maxLen.
     * - If (prefixSum - k) exists in the map, update maxLen using the stored index.
     * - Store prefix sum in the map if not already present.
     * - Time Complexity: O(n), Space Complexity: O(n)
     */
    private static int longestSubarray(int[] nums,int k){
        int n = nums.length;
        int prefixSum = 0, maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<n;i++){
            prefixSum += nums[i];

            // If the current prefix sum is equal to k, the subarray is from 0 to i
            if(prefixSum==k){
                maxLen = Math.max(maxLen, i+1);
            }
            
            // Check if there is a prefix sum that, when subtracted from current, gives k
            int rem = prefixSum - k;
            if(map.containsKey(rem)){
                maxLen = Math.max(maxLen, i - map.get(rem));
            }

            // Store the first occurrence of the prefix sum
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }

        return maxLen;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,3,3};
        int result = longestSubarray(arr, 6);
        System.out.println("Longest subarray sum is: "+result);
    }
}
