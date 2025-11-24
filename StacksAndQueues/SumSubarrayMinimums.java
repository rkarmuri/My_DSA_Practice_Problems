import java.util.Arrays;
import java.util.Stack;

public class SumSubarrayMinimums {
    // Brute Force Approach
    // Time Complexity: O(N^2), Space Complexity: O(1)
    private static int sumOfSubarrayMinimumsBruteForce(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            int currentMin = arr[i];
            for (int j = i; j < n; j++) {
                currentMin = Math.min(currentMin, arr[j]);
                totalSum += currentMin;
            }
        }
        return totalSum % mod;
    }

    // Optimal Approach using Stack
    private static int[] findNSE(int[] arr){
        // Time Complexity: O(N), Space Complexity: O(N)
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nse, n);

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                nse[st.pop()] = i;
            }

            st.push(i);
        }

        return nse;
    }
    private static int[] findPSEE(int[] arr){
        // Time Complexity: O(N), Space Complexity: O(N)
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(psee, -1);

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                psee[st.pop()] = i;
            }

            st.push(i);
        }

        return psee;
    }

    public static int sumOfSubarrayMinimumsOptimal(int[] arr) {
        // Time Complexity: O(5N), Space Complexity: O(2N)
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int mod = (int) 1e9 + 7;
        int sum = 0;

        for(int i = 0; i <n; i++){
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = left * right * 1L; // to avoid integer overflow
            int val = (int)((freq * arr[i]) % mod); // We mod here to avoid overflow and convert back to int

            sum = (sum + val) % mod; // We mod again to keep sum within bounds
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};
        int resultBruteForce = sumOfSubarrayMinimumsBruteForce(arr);
        System.out.println("Sum of Subarray Minimums (Brute Force): " + resultBruteForce);

        int resultOptimal = sumOfSubarrayMinimumsOptimal(arr);
        System.out.println("Sum of Subarray Minimums (Optimal): " + resultOptimal);
    }
}
