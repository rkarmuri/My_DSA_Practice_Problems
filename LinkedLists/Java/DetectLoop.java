package LinkedLists.Java;

public class DetectLoop {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node convertArrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;            
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static boolean detectLoopHashing(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(N) since we are using a HashSet to store visited nodes
        java.util.HashSet<Node> visitedNodes = new java.util.HashSet<>();
        Node current = head;

        while (current != null) {
            if (visitedNodes.contains(current)) {
                System.out.println("Loop detected at node with data: " + current.data);
                return true; // Loop detected
            }
            visitedNodes.add(current);
            current = current.next;
        }
        System.out.println("No loop detected");
        return false; // No loop detected
    }

    public static boolean detectLoop(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(1) since we are using two pointers only
        if (head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2

            if (slow == fast) {
                return true; // Loop detected
            }
        }
        return false; // No loop detected
    }

    public static void main(String[] args) {
        Node head = convertArrayToLinkedList(new int[]{1, 2, 3, 4, 5, 6,7,8,9});
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next; // 5 -> 3 creates a loop
        boolean hasLoop = detectLoop(head);
        System.out.println("Does the linked list have a loop? " + hasLoop);
        boolean hasLoopHashing = detectLoopHashing(head);
        System.out.println("Does the linked list have a loop (using hashing)? " + hasLoopHashing);
    }
}
