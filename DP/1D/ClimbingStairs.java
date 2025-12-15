public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println("Number of ways to climb " + n + " stairs (tabulation) is: " + climbStairsTabulation(n));

        // For comparison, you can also call the memoization function
        int[] dp = new int[n + 1]; // Declare dp array of size n+1
        System.out.println("Number of ways to climb " + n + " stairs (memoization) is: " + climbStairsMemoization(n, dp));
    }

    // Time complexity: O(n), Space complexity: O(1)
    public static int climbStairsTabulation(int n) {
        if (n <= 1) {
            return n;
        }

        int prev2 = 1; // F(1) -> 1 way to climb 1 stair
        int prev1 = 2; // F(2) -> 2 ways to climb 2 stairs

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // Time complexity: O(n), Space complexity: O(n)
    public static int climbStairsMemoization(int n, int[] dp) {
        // Base cases
        if (n <= 2) {
            return n;
        }

        // Check if already computed
        if (dp[n] != 0) {
            return dp[n];
        }

        // Recursive computation with memoization
        dp[n] = climbStairsMemoization(n - 1, dp) + climbStairsMemoization(n - 2, dp);
        
        return dp[n];
    }
}