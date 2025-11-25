package LinkedLists.Java;

public class MiddleNode {
    public static Node convertArrayToLL(int[] arr){
        if(arr.length==0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node mover = head; // This will be used to traverse and add new nodes
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]); // Create a new node with the current array element
            mover.next = temp; // Link the current node to the new node
            mover = temp; // Move the mover pointer to the new node
        }
        return head;
    }

    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // slow is now pointing to the middle node
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrayToLL(arr);

        Node middleNode = MiddleNode.findMiddleNode(head);

        if (middleNode != null) {
            System.out.println("Middle Node: " + middleNode.data);
        } else {
            System.out.println("The linked list is empty.");
        }
    }
}
