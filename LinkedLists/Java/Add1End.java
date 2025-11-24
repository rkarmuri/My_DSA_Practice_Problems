package LinkedLists.Java;

public class Add1End {
    public static class Node {
        int data;
        Node next;

        public Node(int data1, Node next1) {
            this.data = data1;
            this.next = next1;
        }

        public Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }

    private static Node convertArrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
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

    public static Node addOneToEnd(Node head) {
        // Time Complexity: O(3N) where N is the number of nodes in the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        if (head == null) return new Node(1);

        Node reversedHead = reverseLL(head);
        Node temp = reversedHead;

        int carry = 1;

        while (temp != null) {
            temp.data = temp.data + carry;
            if(temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0; 
                carry = 1;
            }
            temp = temp.next; 
        }

        // If there's still a carry left, we need to add a new node at the end
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = reversedHead; // Point the new node to the original head
            reversedHead = newNode; // Update head to the new node
        }

        // Reverse the linked list back to original order
        return reverseLL(reversedHead);
    }

    public static Node addOneToEndRecursive(Node head) {
        int carry = addOneRecursiveHelper(head);
        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    // Helper returns the carry after processing each node
    private static int addOneRecursiveHelper(Node head) {
        if (head == null) return 1; // Add 1 at the end

        int carry = addOneRecursiveHelper(head.next);
        int sum = head.data + carry;
        head.data = sum % 10;
        return sum / 10;
    }

    private static Node reverseLL(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next; // Store the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = nextNode; // Move to the next node
        }
        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        Node head = convertArrayToLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original Linked List:");
        printLinkedList(head);
        
        Node updatedHead = addOneToEnd(head);
        System.out.println("Linked List after adding 1 to the end:");
        printLinkedList(updatedHead);
        Node updatedHeadRecursive = addOneToEndRecursive(head);
        System.out.println("Linked List after adding 1 to the end (Recursive):");
        printLinkedList(updatedHeadRecursive);
    }
    
}
