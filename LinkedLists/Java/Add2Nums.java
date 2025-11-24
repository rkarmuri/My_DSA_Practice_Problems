package LinkedLists.Java;

public class Add2Nums {
    private static class Node {
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

    public static Node addTwoNumbers(Node l1, Node l2) {
        // Time Complexity: O(max(N, M)) where N and M are the lengths of the two linked lists
        // Space Complexity: O(max(N, M)) for the result linked list
        Node dummyHead = new Node(0); // This node is to traverse and build the result linked list
        Node p = l1, q = l2, current = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new Node(sum % 10); // This is the node to be added to the result linked list
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Node head1 = convertArrayToLL(new int[]{9, 9, 3});
        Node head2 = convertArrayToLL(new int[]{7, 8, 4, 9});
        Node result = addTwoNumbers(head1, head2);
        System.out.print("Result Linked List is: ");
        printLinkedList(result);
    }
}
