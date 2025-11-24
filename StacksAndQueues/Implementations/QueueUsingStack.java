public class QueueUsingStack {
    private java.util.Stack<Integer> stack1;
    private java.util.Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new java.util.Stack<>();
        stack2 = new java.util.Stack<>();
    }

    public void push(int value) {
        stack1.push(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);
        queue.push(60);
        System.out.println("Front element is: " + queue.peek()); // 10

        System.out.println("Popped element is: " + queue.pop()); // 10
        System.out.println("Popped element is: " + queue.pop()); // 20

        System.out.println("Is queue empty? " + queue.isEmpty()); // false
        
        queue.push(70);
        queue.push(80);
        queue.push(90);
    }
}
