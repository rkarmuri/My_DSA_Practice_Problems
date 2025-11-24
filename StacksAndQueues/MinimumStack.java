import java.util.Stack;
public class MinimumStack {
    // Brute Force Approach
    // Time Complexity: O(1) for push, pop, top; O(n) for getMin
    // Space Complexity: O(n)
    private Stack<int[]> stack;
    public MinimumStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new int[]{val, val});
        }  
        int currentMin = Math.min(val, getMin());
        stack.push(new int[]{val, currentMin});
        
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
    public static void main(String[] args) {
        MinimumStack minStack = new MinimumStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current Min: " + minStack.getMin()); // Returns -3
        minStack.pop();
        minStack.getMin();
        minStack.push(0);
        minStack.push(6);
        System.out.println("Top Element: " + minStack.top());    // Returns 0
        System.out.println("Current Min: " + minStack.getMin()); // Returns -2
    }
}
