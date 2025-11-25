package LinkedLists.Java;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public Node mergeKLists(Node[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        for(Node list : lists) {
            if(list != null) {
                minHeap.offer(list);
            }
        }

        Node dummy = new Node(0);
        Node current = dummy;

        while(!minHeap.isEmpty()){
            Node smallesNode = minHeap.poll();
            current.next = smallesNode;
            current = current.next;

            if(smallesNode.next != null) {
                minHeap.offer(smallesNode.next);
            }
        }

        return dummy.next;
    }

    private static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        Node[] lists = new Node[3];
        lists[0] = new Node(1, new Node(4, new Node(5)));
        lists[1] = new Node(1, new Node(3, new Node(4)));
        lists[2] = new Node(2, new Node(6));

        MergeKSortedLists mergedList = new MergeKSortedLists();
        Node result = mergedList.mergeKLists(lists);
        System.out.print("Merged Linked List: ");
        printList(result);
    }
}
