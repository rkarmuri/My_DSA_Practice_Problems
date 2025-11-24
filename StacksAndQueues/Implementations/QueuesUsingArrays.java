public class QueuesUsingArrays {
    private int maxSize;
    private int[] queueArray;
    private int start;
    private int end;
    private int currSize;

    public QueuesUsingArrays(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.start = -1;
        this.end = -1;
        this.currSize = 0;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        if (end == maxSize - 1) {
            end = -1; // wrap around
        }
        queueArray[++end] = value;
        currSize++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int temp = queueArray[start++];
        if (start == maxSize) {
            start = 0; // wrap around
        }
        currSize--;
        return temp;
    }

    public int peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueArray[start];
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == maxSize;
    }

    public static void main(String[] args) {
        QueuesUsingArrays queue = new QueuesUsingArrays(10);
        
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);
        System.out.println("Front element is: " + queue.peekFront()); // 10

        System.out.println("Popped element is: " + queue.pop()); // 10
        System.out.println("Popped element is: " + queue.pop()); // 20

        System.out.println("Is queue empty? " + queue.isEmpty()); // false
        
        queue.push(60);
        queue.push(70);
        System.out.println("Front element is: " + queue.peekFront()); // 30
    }
}
