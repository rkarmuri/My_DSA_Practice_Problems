import java.util.LinkedList;
import java.util.Queue;
public class StackUsingQueues {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
       int s = q.size();
       q.add(x);

       for(int i = 0; i < s; i++){
        q.add(q.poll());
       }
    }

    public int pop() {
        if (q.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q.poll();
    }

    public int top() {
        if (q.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println("Top element is: " + stack.top()); // 60

        System.out.println("Popped element is: " + stack.pop()); // 60
        System.out.println("Popped element is: " + stack.pop()); // 50

        System.out.println("Is stack empty? " + stack.isEmpty()); // false
        
        stack.push(40);
        stack.push(50);
        stack.push(60);
    }
}
