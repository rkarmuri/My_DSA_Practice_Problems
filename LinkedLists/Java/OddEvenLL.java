package LinkedLists.Java;

import java.util.ArrayList;

public class OddEvenLL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private static Node convertArrayToLL(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node mover = head; // This will be used to traverse and add new nodes
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]); // Create a new node with the current array element
            mover.next = temp; // Link the current node to the new node
            mover = temp; // Move the mover pointer to the new node
        }
        return head;
    }
    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }
    public static Node oddEvenList(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        // We pick even for conditional check because the even nodes always end second
        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link the next odd node
            even.next = even.next.next; // Link the next even node
            odd = odd.next; // Move to the next odd node
            even = even.next; // Move to the next even node
        }

        odd.next = evenHead; // Link the end of odd list to the head of even list
        return head;
    }

    private static Node oddEvenBruteForce(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(N) since we are using an ArrayList to store the node values
        if (head == null||head.next==null) return null;
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;

        // First, collect odd-indexed nodes (1st, 3rd, 5th, ...)
        while (temp != null) {
            arr.add(temp.data);
            temp = (temp.next != null && temp.next.next != null) ? temp.next.next : null;
        }

        // Now, collect even-indexed nodes (2nd, 4th, 6th, ...)
        temp = head.next;
        while (temp != null) {
            arr.add(temp.data);
            temp = (temp.next != null && temp.next.next != null) ? temp.next.next : null;
        }

        // Now, update the linked list with the new order
        temp = head;
        int i = 0;
        while (temp != null && i < arr.size()) {
            temp.data = arr.get(i++);
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = convertArrayToLL(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original Linked List:");
        printLinkedList(head);
        
        Node modifiedHead = oddEvenList(head);
        System.out.println("Modified Linked List:");
        printLinkedList(modifiedHead);

        Node head2 = convertArrayToLL(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("Original Linked List:");
        printLinkedList(head2);
        Node modifiedHead2 = oddEvenBruteForce(head2);
        System.out.println("Modified Linked List:");
        printLinkedList(modifiedHead2);
    }
}
