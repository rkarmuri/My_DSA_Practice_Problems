package LinkedLists.Java;

public class LengthOfLoop {
    public static void main(String[] args) {
        // Create a linked list with a loop for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next; // Create a loop here

        int loopLength = findLengthOfLoop(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop is: " + loopLength);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }

    private static int findLengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                // Calculate the length of the loop
                int length = 1;
                Node current = slow;
                while (current.next != slow) {
                    length++;
                    current = current.next;
                }
                return length;
            }
        }

        // If no loop detected
        return 0;
    }
}
