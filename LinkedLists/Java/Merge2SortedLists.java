package LinkedLists.Java;

public class Merge2SortedLists {
    public Node mergeTwoLists(Node list1, Node list2) {
        Node dummyNode = new Node(0);
        Node curr = dummyNode;

        while(list1 != null && list2 != null){
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
        // Create first sorted linked list: 1 -> 3 -> 5
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        // Create second sorted linked list: 2 -> 4 -> 6
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        Merge2SortedLists merger = new Merge2SortedLists();
        Node mergedList = merger.mergeTwoLists(list1, list2);

        // Print the merged linked list
        Node current = mergedList;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
