package LinkedLists.Java;

public class DutchFlagLL {
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

    private static Node dutchFlagLL(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        if(head==null||head.next==null){
            return head;
        }
        
        Node temp = head;
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        
        while(temp!=null){
            if(temp.data==0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data==1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        
        zero.next = (oneHead.next!=null)?oneHead.next:twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        
        return zeroHead.next;
    }

    // DutchFlagBrute for a singly linked list with 0s, 1s, and 2s
    public static Node dutchFlagBrute(Node head) {
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        if (head == null || head.next == null) {
            return head;
        }
        Node tmp = head;
        int cnt0 = 0, cnt1 = 0;

        // Count occurrences of 0, 1, and 2
        while (tmp != null) {
            if (tmp.data == 0) cnt0++;
            else if (tmp.data == 1) cnt1++;
            tmp = tmp.next;
        }

        // Overwrite the linked list with sorted values
        tmp = head;
        while (tmp != null) {
            if (cnt0 > 0) {
                tmp.data = 0;
                cnt0--;
            } else if (cnt1 > 0) {
                tmp.data = 1;
                cnt1--;
            } else {
                tmp.data = 2;
            }
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = convertArrayToLL(new int[]{1, 0, 2, 1, 0, 2, 1, 0});
        System.out.println("Original Linked List:");
        printLinkedList(head);
        head = dutchFlagLL(head);
        System.out.println("Dutch Flag Sorted Linked List:");
        printLinkedList(head);
        Node head2 = convertArrayToLL(new int[]{1, 0, 2, 1, 0, 2, 1, 0,0,0,1,1,1,2,2,2,2});
        System.out.println("Original Linked List:");
        printLinkedList(head2);
        head2 = dutchFlagBrute(head2);
        System.out.println("Dutch Flag Sorted Linked List (Brute Force):");
        printLinkedList(head2);
    }
}
