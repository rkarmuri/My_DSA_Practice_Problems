package LinkedLists.Java;

public class StartOfLoop {
    public static void main(String[] args) {
        // Create a linked list with a loop for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next; // Create a loop here

        Node loopStartNode = findStartOfLoop(head);
        if (loopStartNode != null) {
            System.out.println("Loop starts at node with value: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }

    private static Node findStartOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        // If no loop detected
        return null;
    }
}
