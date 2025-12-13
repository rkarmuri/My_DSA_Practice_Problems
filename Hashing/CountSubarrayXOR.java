public class CountSubarrayXOR {
    /**
     * Problem: Count the number of subarrays whose XOR equals k.
     * 
     * Approach:
     * - Use a HashMap to store the frequency of prefix XORs.
     * - For each element, calculate the running prefix XOR.
     * - If (prefixXOR ^ k) exists in the map, it means there is a subarray ending at the current index with XOR k.
     * - Add the frequency of (prefixXOR ^ k) to the answer.
     * - Update the frequency of the current prefix XOR in the map.
     * - Time Complexity: O(n), Space Complexity: O(n)
     */
    private static int subArrayXOR(int[] nums, int k){
        int n = nums.length, ans = 0, prefixXOR = 0;
        java.util.HashMap<Integer,Integer> map = new java.util.HashMap<>();
        
        // Initialize with prefix XOR 0 having frequency 1
        map.put(0, 1);
        for(int i = 0;i<n;i++){
            prefixXOR ^= nums[i];
            int rem = prefixXOR ^ k;

            // If rem exists, add its frequency to answer
            if(map.containsKey(rem)){
                ans += map.get(rem);
            }
            
            // Update the frequency of the current prefix XOR
            map.put(prefixXOR,map.getOrDefault(prefixXOR, 0)+1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int res = subArrayXOR(arr, 6);
        System.out.println("The no of subarrays found in the array are: "+ res);

    }
}
