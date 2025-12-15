public class FibonacciMemoization {
    public static void main(String[] args) {
        int n = 10; // Example input
        int[] dp = new int[n + 1]; // Step 1: Declare dp array of size n+1
        System.out.println("Fibonacci (memoization) of " + n + " is: " + fibonacci(n, dp));

        // For comparison, you can also call the recursive function without memoization
        System.out.println("Fibonacci (recursive) of " + n + " is: " + fibonacciRecursive(n));
    }

    // Time complexity: O(n), Space complexity: O(n)
    public static int fibonacci(int n, int[] dp) {
        // Step 2: Base cases
        if (n <= 1) {
            return n;
        }

        // Step 3: Check if already computed
        if (dp[n] != 0) {
            return dp[n];
        }

        // Step 4: Recursive computation with memoization
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }

    // Recursive function without memoization (for comparison)
    // Time complexity: O(2^n), Space complexity: O(n)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
