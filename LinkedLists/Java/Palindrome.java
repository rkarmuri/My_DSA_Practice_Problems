package LinkedLists.Java;

public class Palindrome {
    public static class Node {
        int data;
        Node next;
        
        public Node(int data1, Node next1){
            this.data = data1;
            this.next = next1;
        }
        
        public Node(int data1){
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

    private static void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static boolean isPalindrome(Node head){
        if(head==null||head.next==null){
            return true;
        }
        
        Node slow = head, fast = head;
        // We are moving to the node before the middle node
        // in case of odd length linked list
        // and to the middle node in case of even length linked list
        // This is done so that we can reverse the second half of the linked list
        // and compare it with the first half
        // Time Complexity: O(N) where N is the number of nodes in the linked list
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node secondHalfStart = reverseLL(slow.next);
        Node left = head;
        Node right = secondHalfStart;
        boolean result=true;
        
        while(right!=null){
            if(left.data!=right.data){
                result = false;
                slow.next = reverseLL(secondHalfStart);
                break;
            }
            left = left.next;
            right = right.next;
        }
        
        return result;
    }

    private static Node reverseLL(Node head) {
        Node prev = null;
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next; // Store the next node
            temp.next = prev; // Reverse the link
            prev = temp; // Move prev to temp
            temp = nextNode; // Move to the next node
        }
        return prev; // New head of the reversed list
    }

    private static boolean isPalindromeBruteForce(Node head){
        if(head==null||head.next==null){
            return true;
        }

        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node temp = head;

        // Push all nodes onto the stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // Check if the linked list is a palindrome
        temp = head;
        while (!stack.isEmpty()) {
            if (temp.data != stack.pop().data) {
                return false; // Not a palindrome
            }
            temp = temp.next;
        }
        return true; // Is a palindrome
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        Node head = convertArrayToLinkedList(arr);
        printLinkedList(head);
        System.out.println("Is the given Linked List a Palindrome? " + isPalindrome(head));
        System.out.println("Is the given Linked List a Palindrome (Brute Force)? " + isPalindromeBruteForce(head));
    }
}
