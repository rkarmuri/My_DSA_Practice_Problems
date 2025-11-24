import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    // time complexity: O(n), space complexity: O(n)
    private static int[] nse(int[] arr, int n) {
        int[] nse = new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        return nse;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;
        int[] result = nse(arr, n);
        System.out.println("Next Smaller Element indices: " + Arrays.toString(result));
    }
}
