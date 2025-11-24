import java.util.Stack;

public class MaximalRectangle {
    /* Intuition: We can treat each row of the matrix as the base of a histogram.
       For each row, we calculate the heights of the histogram bars and then use
       the largest rectangle in histogram approach to find the maximal rectangle.
       Time Complexity: O(m * n), Space Complexity: O(n)
    */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int n = matrix[0].length;
        int[] heights = new int[n];

        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleAreaOptimal(heights));
        }
        return maxArea;
    }

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
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix)); // Output: 6
    }
}
