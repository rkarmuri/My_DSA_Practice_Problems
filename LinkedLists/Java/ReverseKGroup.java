package LinkedLists.Java;

public class ReverseKGroup {
    public static void main(String[] args) {
        // Create a linked list for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2; // Size of groups to reverse
        ReverseKGroup solution = new ReverseKGroup();
        head = solution.reverseKGroup(head, k);

        // Print the modified linked list
        printLinkedList(head);
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    private Node findKthNode(Node head, int k){
        Node temp = head;
        k = k - 1;
        while(k>0 && temp!=null){
            temp = temp.next;
            k--;
        }
        
        return temp;
    }

    private Node reverseLL(Node head){
        Node current = head;
        Node prev = null;

        while(current!=null){
            Node front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }

        return prev;
    }

    public Node reverseKGroup(Node head, int k) {
        if(head==null||head.next==null) return head;

        Node temp = head;
        Node prevNode = null;
        Node nextNode = null;

        while(temp!=null){
            Node kThNode = findKthNode(temp,k);
            if(kThNode==null){
                if(prevNode!=null){
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kThNode.next;
            kThNode.next = null;

            reverseLL(temp);
            if(temp==head){
                head = kThNode;
            } else {
                prevNode.next = kThNode;
            }

            prevNode = temp;
            temp = nextNode;

        }

        return head;
    }
}
