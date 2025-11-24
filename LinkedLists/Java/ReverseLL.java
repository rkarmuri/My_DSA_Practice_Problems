package LinkedLists.Java;

public class ReverseLL {
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

    public static Node reverseList(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        Node prev = null;
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next; // Store the next node
            temp.next = prev; // Reverse the link
            prev = temp; // Move prev to current
            temp = nextNode; // Move to the next node
        }
        return prev; // New head of the reversed list
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private static Node reverseListBruteForce(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(N) since we are using a stack to store the nodes
        if (head == null || head.next == null) return head;

        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node current = head;

        // Push all nodes onto the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // Pop nodes from the stack to reverse the linked list
        Node newHead = stack.pop();
        current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null; // Set the last node's next to null

        return newHead; // Return the new head of the reversed list
    }

    private static Node reverseListRecursive(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(N) due to recursion stack space
        if (head == null || head.next == null) return head;

        // Solve the list for the smaller problem
        // and then reverse the link
        // between the current node and the next node
        Node newHead = reverseListRecursive(head.next);
        Node nextNode = head.next; // Store the next node
        nextNode.next = head; // Reverse the link
        head.next = null; // Set the next of the current node to null

        return newHead; // Return the new head of the reversed list
    }

    public static void main(String[] args) {
        Node head = convertArrayToLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original Linked List:");
        printLinkedList(head);

        Node reversedHead = reverseList(head);
        System.out.println("Reversed Linked List:");
        printLinkedList(reversedHead);
        
        Node bruteForceReversedHead = reverseListBruteForce(reversedHead);
        System.out.println("Reversed Linked List using Brute Force:");
        printLinkedList(bruteForceReversedHead);
        Node recursiveReversedHead = reverseListRecursive(bruteForceReversedHead);
        System.out.println("Reversed Linked List using Recursion:");
        printLinkedList(recursiveReversedHead);
        // Note: The original head is now reversed, so we can reverse it again to get back the original order
    }
}
