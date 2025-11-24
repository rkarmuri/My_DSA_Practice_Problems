import java.util.Stack;

public class TrappingWater {
    // Brute Force Approach
    // Intution: For each element, find the maximum height to its left and right.
    // The water trapped on top of that element will be the minimum of these two heights minus the height of the element itself.
    public int trap(int[] height) {
        // Time Complexity: O(3n), Space Complexity: O(2n)
        int n = height.length;
        int totalWater = 0;

        int[] leftMax = findPrefixMax(height, n);
        int[] rightMax = findSuffixMax(height, n);

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            if (waterLevel > height[i]) {
                totalWater += waterLevel - height[i];
            }
        }
        return totalWater;
    }

    private int[] findPrefixMax(int[] height, int n) {
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        return leftMax;
    }

    private int[] findSuffixMax(int[] height, int n) {
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        return rightMax;
    }

    // Better approach using two pointers can be implemented here for improved space efficiency.
    public int trapTwoPointers(int[] height) {
        // Time Complexity: O(n), Space Complexity: O(1)
        int n = height.length;
        int result = 0, leftMax = 0, rightMax = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (leftMax < rightMax) {
                result += leftMax - height[l];
                l++;
            } else {
                result += rightMax - height[r];
                r--;
            }
        }
        return result;
    }

    // Using stack approach can also be implemented here.
    // Time Complexity: O(n), Space Complexity: O(n)
    public int trapStack(int[] height) {
        int n = height.length;
        int totalWater = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            /*
             * Check if the current height is greater than the height at the top of the stack.
             * If it is, we have found a right boundary for trapping water.
             */
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                /* Pop the top element which represents the bottom of the trapped water. */
                int top = stack.pop();
                /* If the stack is empty after popping, it means there is no left boundary to trap water. */
                if (stack.isEmpty()) {
                    break;
                }
                /* Calculate the width between the left and right boundaries excluding the popped element.
                 * This contains the bars in between the left and right boundaries.
                 */
                int distance = i - stack.peek() - 1;
                /* Calculate the bounded height of water that can be trapped which is
                the minimum of the two boundaries minus the height of the popped element. */
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                // Total area between the left and right boundaries.
                totalWater += distance * boundedHeight;
            }
            stack.push(i);
        }
        return totalWater;
    }

    public static void main(String[] args) {
        TrappingWater trappingWater = new TrappingWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trappingWater.trap(height);
        System.out.println("Total trapped water using Brute Force: " + result); // Output: 6

        int resultStack = trappingWater.trapStack(height);
        System.out.println("Total trapped water using Stack: " + resultStack); // Output: 6

        int resultTwoPointers = trappingWater.trapTwoPointers(height);
        System.out.println("Total trapped water using Two Pointers: " + resultTwoPointers); // Output: 6
    }
}
