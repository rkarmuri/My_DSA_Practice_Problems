package LinkedLists.Java;

public class RemoveNthNode {
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

    public static Node removeNthFromEnd(Node head, int n) {
        // Time Complexity: O(L) where L is the length of the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        Node fast = head;
        Node slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null){
                System.out.println("The list is shorter than " + n + " nodes. No node removed.");
                return head; // If n is greater than the length of the list
            } 
            fast = fast.next;
        }
        // If fast is null, we need to remove the head
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // Remove the nth node from the end
        return head; // Return the modified list
    }

    // Brute force method to remove the nth node from the end
    private static Node removeNthFromEndBruteForce(Node head, int n) {
        // Time Complexity: O(L) where L is the length of the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        int length = 0;
        Node current = head;

        // Calculate the length of the linked list
        while (current != null) {
            length++;
            current = current.next;
        }

        // If n is greater than the length of the list, return the original list
        if (n > length) {
            System.out.println("The list is shorter than " + n + " nodes. No node removed.");
            return head;
        }

        // If we need to remove the head
        if (n == length) {
            return head.next;
        }

        current = head;
        for (int i = 1; i < length - n; i++) {
            current = current.next;
        }
        current.next = current.next.next; // Remove the nth node from the end
        return head; // Return the modified list
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = convertArrayToLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original Linked List:");
        printLinkedList(head);

        int n = 3; // Remove the 2nd node from the end
        head = removeNthFromEnd(head, n);
        System.out.println("Linked List after removing " + n + "th node from the end:");
        printLinkedList(head);

        // Testing the brute force method
        Node head2 = convertArrayToLinkedList(new int[]{1, 5, 8, 2, 7});
        System.out.println("Original Linked List for brute force:");
        printLinkedList(head2);
        head2 = removeNthFromEndBruteForce(head2, n);
        System.out.println("Linked List after brute force removing " + n + "th node from the end:");
        printLinkedList(head2);
    }
}
