public class StackUsingArrays {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackUsingArrays(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays(10);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println("Top element is: " + stack.peek()); // 60

        System.out.println("Popped element is: " + stack.pop()); // 60
        System.out.println("Popped element is: " + stack.pop()); // 50

        System.out.println("Is stack empty? " + stack.isEmpty()); // false
        
        stack.push(40);
        stack.push(50);
        stack.push(60);
        
        System.out.println("Is stack full? " + stack.isFull()); // true
    }
}
