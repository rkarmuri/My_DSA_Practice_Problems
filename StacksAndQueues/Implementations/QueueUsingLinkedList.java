public class QueueUsingLinkedList {
    private Node front;
    private Node rear;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int poppedValue = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        
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
