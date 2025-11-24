import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    // Brute Force Approach: O(n^2) time complexity, O(1) space complexity
    public static int[] calculateSpanBruteForce(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        for (int i = 0; i < n; i++) {
            spans[i] = 0;
            for (int j = i; j >= 0 && prices[j] <= prices[i]; j--) {
                spans[i]++;
            }
        }
        return spans;
    }

    private static int[] findPGEE(int[] arr){
        int n = arr.length;
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(pgee, -1);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) pgee[i] = st.peek();
            st.push(i);
        }

        return pgee;
    }

    // Optimal Approach: O(n) time complexity, O(n) space complexity
    public static int[] calculateSpanOptimal(int[] arr) {
        int n = arr.length;
        int[] spans = new int[n];
        int[] pgee = findPGEE(arr);

        for (int i = 0; i < n; i++) {
            spans[i] = (pgee[i] == -1) ? (i + 1) : (i - pgee[i]);
        }
        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spansBruteForce = calculateSpanBruteForce(prices);
        int[] spansOptimal = calculateSpanOptimal(prices);

        System.out.println("Stock Prices: " + Arrays.toString(prices));
        System.out.println("Span (Brute Force): " + Arrays.toString(spansBruteForce));
        System.out.println("Span (Optimal): " + Arrays.toString(spansOptimal));
    }
}
