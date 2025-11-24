import java.util.Stack;
import java.util.Arrays;
public class LargestRectangleHistogram {

    /* Intution: For each bar in the histogram, we need to find the nearest smaller bar on the left and right.
       The area of the rectangle that can be formed with the current bar as the smallest height
       is determined by the distance between these two smaller bars.
       Time Complexity: O(5n), Space Complexity: O(3n)
    */
    private static int largestRectangleArea(int[] heights){
        int n = heights.length;
        int maxArea = 0;

        int[] nextSmaller = findNextSmallerElements(heights, n);
        int[] prevSmaller = findPrevSmallerElements(heights, n);

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int[] findNextSmallerElements(int[] heights, int n) {
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.peek();
            stack.push(i);
        }
        return nextSmaller;
    }

    private static int[] findPrevSmallerElements(int[] heights, int n) {
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.peek();
            stack.push(i);
        }
        return prevSmaller;
    }

    // Optimal approach using a single stack
    // Time Complexity: O(n), Space Complexity: O(n)
    public static int largestRectangleAreaOptimal(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i]; // Covers the case when we reach the end
            // At every step, we check if the current height is less than the height of the bar at the index stored at the top of the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Pop the previous bar height
                int right = i; // Current index is the right boundary
                int left = stack.isEmpty() ? -1 : stack.peek(); // Left boundary
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights2 = {3, 5, 1, 7, 5, 9, 2, 6, 4};
        int maxArea = largestRectangleArea(heights);
        System.out.println("The largest rectangle area of " + Arrays.toString(heights) + " in the histogram is: " + maxArea);

        int maxAreaOptimal = largestRectangleAreaOptimal(heights);
        System.out.println("The largest rectangle area of " + Arrays.toString(heights) + " in the histogram (Optimal) is: " + maxAreaOptimal);

        int maxArea2 = largestRectangleArea(heights2);
        System.out.println("The largest rectangle area of " + Arrays.toString(heights2) + " in the histogram is: " + maxArea2);

        int maxAreaOptimal2 = largestRectangleAreaOptimal(heights2);
        System.out.println("The largest rectangle area of " + Arrays.toString(heights2) + " in the histogram (Optimal) is: " + maxAreaOptimal2);
    }
}
