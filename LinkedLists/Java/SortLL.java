package LinkedLists.Java;

public class SortLL {

    public Node sortList(Node head) {
        if(head==null||head.next==null) return head;

        // Find the middle of the linked list
        Node middle = findMiddle(head);

        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeTwoSortedLinkedLists(leftHead,rightHead);

    }

    public static Node findMiddle(Node head) {
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

    public Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
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
        // Example usage
        int[] arr = {4, 2, 1, 3};
        Node head = MiddleNode.convertArrayToLL(arr);

        SortLL sorter = new SortLL();
        Node sortedHead = sorter.sortList(head);

        // Print the sorted linked list
        Node current = sortedHead;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
