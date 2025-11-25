package LinkedLists.Java;

public class RotateLL {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2; // Number of positions to rotate

        head = rotateRight(head, k);

        // Print the rotated linked list
        printLinkedList(head);
    }

    private static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head; // No rotation needed
        }

        // Compute the length of the linked list
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the linked list circular
        tail.next = head;

        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        k = k % length;
        Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
