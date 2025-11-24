import java.util.Arrays;
import java.util.Stack;

public class NGECircular {
    // Brute Force Approach for Circular Next Greater Element
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public static int[] findNextGreaterElementsCircular(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        Arrays.fill(result, -1); // Default value if no greater element is found
        for (int i = 0; i < n; i++) {
            int currEle = arr[i];
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                if (arr[index] > currEle) {
                    result[i] = arr[index];
                    break;
                }
            }
        }
        return result;
    }

    // Optimal Approach using Stack for Circular Next Greater Element
    // Time Complexity: O(n), Space Complexity: O(n)
    private static int[] findNextGreaterElementsCircularOptimal(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Hypothetically traverse the array twice from the end and store the 
        // elements in the stack to simulate circular nature
        for(int i = 2 * n - 1; i >= 0; i--) {
            int circularIndex = i % n; // To handle circular indexing
            
            // This is to handle the 2nd half starting from the 2*n-1 index
            // We pop elements from the stack which are less than or equal to the current element
            while(!stack.isEmpty() && stack.peek() <= arr[circularIndex]) {
                stack.pop();
            }

            // This is for the 1st half where we store the result
            if(i < n) {
                if(stack.isEmpty()) {
                    ans[circularIndex] = -1;
                } else {
                    ans[circularIndex] = stack.peek();
                }
            }

            stack.push(arr[circularIndex]); // Push the current element onto the stack
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 7, 1};
        int[] ngeCircular = findNextGreaterElementsCircular(arr);

        System.out.println("Brute Force Circular Next Greater Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + ngeCircular[i]);
        }
        int[] ngeCircularOptimal = findNextGreaterElementsCircularOptimal(arr);
        System.out.println("\nOptimal Circular Next Greater Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + ngeCircularOptimal[i]);
        }
    }
}
