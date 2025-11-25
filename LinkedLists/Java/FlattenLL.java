package LinkedLists.Java;

public class FlattenLL {
    private static class Node {
        int data;
        Node next;
        Node child;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }
    
    public Node flattenLinkedList(Node head) {
        if(head==null||head.next==null) return head;

        Node mergedHead = flattenLinkedList(head.next);

        head = mergeTwoSortedLinkedLists(head, mergedHead);

        return head;

    }

    private Node mergeTwoSortedLinkedLists(Node list1, Node list2){
        Node dummyNode = new Node(0);
        Node curr = dummyNode;

        while(list1!=null && list2!=null){
            if(list1.data < list2.data){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // Create a multi-level linked list for testing
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.child = new Node(7);
        head.child.next = new Node(8);
        head.child.next.next = new Node(30);

        head.next.child = new Node(20);

        head.next.next.child = new Node(22);
        head.next.next.child.next = new Node(50);

        head.next.next.next.child = new Node(35);
        head.next.next.next.child.next = new Node(40);
        head.next.next.next.child.next.next = new Node(45);

        FlattenLL flattener = new FlattenLL();
        Node flattenedList = flattener.flattenLinkedList(head);

        // Print the flattened linked list
        Node current = flattenedList;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
