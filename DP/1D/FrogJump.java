public class FrogJump {
    public int frogJumpMemoization(int[] heights) {
        // Time complexity: O(n), Space complexity: O(n)
        int n = heights.length;
        int[] dp = new int[n]; // Step 1: Declare dp array of size n
        return helper(heights, n - 1, dp);
    }

    public int helper(int[] heights, int index, int[] dp){
        if(index == 0)  return 0;

        if(dp[index] != 0)  return dp[index]; // Step 2: Check if already computed

        // Find the minimum energy required to reach the current index
        int prev = helper(heights, index - 1, dp) + Math.abs(heights[index - 1] - heights[index]);

        int prev2 = Integer.MAX_VALUE; // To handle the edge case when index is 1 because index-2 would be -1

        if(index > 1){
            // Find the minimum energy required to reach the current index by jumping from index-2
            prev2 = helper(heights, index - 2, dp) + Math.abs(heights[index - 2] - heights[index]);
        }

        return dp[index] = Math.min(prev, prev2); // Step 3: Store computed value in dp array
    }

    // Recursive approach without memoization (for comparison)
    public int frogJumpRecursive(int[] heights, int index){
        if(index == 0)  return 0;

        int prev = frogJumpRecursive(heights, index - 1) + Math.abs(heights[index - 1] - heights[index]);
        int prev2 = Integer.MAX_VALUE;

        if(index > 1){
            prev2 = frogJumpRecursive(heights, index - 2) + Math.abs(heights[index - 2] - heights[index]);
        }

        return Math.min(prev, prev2);
    }

    // Tabulation approach)
    public int frogJumpTabulation(int[] heights){
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for(int i = 1; i < n; i++){
            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;

            if(i > 1){
                jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(jumpOne, jumpTwo);
        }

        return dp[n - 1];
    }

    // Space optimized tabulation approach
    public int frogJumpTabulationSpaceOptimized(int[] heights){
        int n = heights.length;
        int prev = 0; // dp[0]
        int prev2 = 0; // To store dp[i-2]

        for(int i = 1; i < n; i++){
            int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;

            if(i > 1){
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(jumpOne, jumpTwo);
            prev2 = prev; // Update prev2 to previous prev
            prev = curr; // Update prev to current
        }

        return prev; // dp[n-1]
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int[] heights = {10, 30, 40, 20}; // Example input
        System.out.println("Minimum energy required (recursive) is: " + frogJump.frogJumpRecursive(heights, heights.length - 1));
        System.out.println("Minimum energy required (memoization) is: " + frogJump.frogJumpMemoization(heights));
        System.out.println("Minimum energy required (tabulation) is: " + frogJump.frogJumpTabulation(heights));
        System.out.println("Minimum energy required (space optimized tabulation) is: " + frogJump.frogJumpTabulationSpaceOptimized(heights));
    }
}
