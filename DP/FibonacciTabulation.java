public class FibonacciTabulation {
    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.println("Fibonacci (tabulation) of " + n + " is: " + fibonacci(n));
        System.out.println("Fibonacci (optimized) of " + n + " is: " + fibonacciOptimized(n));
    }

    // Time complexity: O(n), Space complexity: O(n)
    public static int fibonacci(int n) {
        // Step 1: Create dp array of size n+1
        int[] dp = new int[n + 1];

        // Step 2: Base cases
        dp[0] = 0;
        if (n > 0) {
            dp[1] = 1;
        }

        // Step 3: Fill the dp array iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Step 4: Return the nth Fibonacci number
        return dp[n];
    }

    // Space optimization: Using two variables instead of an array
    // Time complexity: O(n), Space complexity: O(1)
    public static int fibonacciOptimized(int n) {
        if (n <= 1) {
            return n;
        }

        int prev = 0; // F(0)
        int curr = 1; // F(1)
        for (int i = 2; i <= n; i++) {
            int next = prev + curr; // F(i) = F(i-1) + F(i-2)
            prev = curr; // Move to next
            curr = next; // Move to next
        }

        return curr; // F(n)
    }
}
