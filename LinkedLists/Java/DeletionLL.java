package LinkedLists.Java;

public class DeletionLL {
    private static Node convertArrayToLL(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static Node deleteHead(Node head) {
        if (head == null) {
            return null;
        }
        return head.next; // Return the next node as the new head
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null; // If list is empty or has only one node
        }
        Node tmp = head;
        while (tmp.next.next != null) { // Traverse to the second last node
            tmp = tmp.next;
        }
        tmp.next = null; // Remove the last node
        return head;
    }

    private static Node deleteValue(Node head, int item) {
        if (head == null) {
            return null; // List is empty
        }
        
        if (head.data == item) { // If the item is at the head
            return deleteHead(head);
        }

        Node tmp = head;
        while (tmp.next != null && tmp.next.data != item) { // Find the node before the one to delete
            tmp = tmp.next;
        }

        if (tmp.next != null) { // If the item was found
            tmp.next = tmp.next.next; // Bypass the node to delete it
        }
        
        return head; // Return the modified list
    }

    private static int lengthOfLL(Node head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            length += 1;
            head = head.next;
        }
        return length;
    }

    private static Node deleteAfterPostition(Node head, int pos) {
        if (head == null || pos < 0) {
            return head; // Invalid position or empty list
        }
        
        if (pos == 0) { // If position is 0, delete head
            return deleteHead(head);
        }

        int lengthLL = lengthOfLL(head);
        if (pos >= lengthLL) {
            return head; // If position is out of bounds, do nothing
        }
        if (head.next == null) {
            return null; // If there's only one node, return null
        }
        // Traverse to the node before the one to delete
        Node tmp = head;
        for (int i = 0; i < pos - 1 && tmp != null; i++) {
            tmp = tmp.next; // Traverse to the node before the one to delete
        }

        if (tmp != null && tmp.next != null) { // If the next node exists
            tmp.next = tmp.next.next; // Bypass the node to delete it
        }
        
        return head; // Return the modified list
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrayToLL(arr);
        
        System.out.println("Original Linked List:");
        printLinkedList(head);
        
        head = deleteHead(head);
        System.out.println("After deleting head:");
        printLinkedList(head);
        
        head = deleteTail(head);
        System.out.println("After deleting tail:");
        printLinkedList(head);

        int itemToDelete = 3;
        head = deleteValue(head, itemToDelete);
        System.out.println("After deleting value " + itemToDelete + ":");
        printLinkedList(head);

        int posToDelete = 1;
        head = deleteAfterPostition(head, posToDelete);
        System.out.println("After deleting node at position " + posToDelete + ":");
        printLinkedList(head);
    }

}
