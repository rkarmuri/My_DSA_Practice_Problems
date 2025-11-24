import java.util.Arrays;
import java.util.Stack;
public class PreviousSmallerElement {
    private static int[] pse(int[] arr, int n) {
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }
        return pse;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;
        int[] result = pse(arr, n);
        System.out.println("Previous Smaller Element indices: " + Arrays.toString(result));
    }
}
