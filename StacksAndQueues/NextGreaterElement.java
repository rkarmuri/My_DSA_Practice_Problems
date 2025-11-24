public class NextGreaterElement {
    public static int[] findNextGreaterElements(int[] arr) {
        // Time Complexity: O(n), Space Complexity: O(n)
        int n = arr.length;
        int[] result = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    // Brute Force Approach
    private static int[] findNextGreaterElementsBruteForce(int[] arr) {
        // Time Complexity: O(n^2), Space Complexity: O(1)
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1; // Default value if no greater element is found
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] nge = findNextGreaterElements(arr);
        int[] ngeBrute = findNextGreaterElementsBruteForce(arr);

        System.out.println("Next Greater Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + nge[i]);
        }

        System.out.println("\nBrute Force Next Greater Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + ngeBrute[i]);
        }
    }
}
