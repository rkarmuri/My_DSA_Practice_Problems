package LinkedLists.Java;

public class IntersectionNode {
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

    public static Node getIntersectionNodeHashing(Node head1, Node head2) {
        // Time Complexity: O(N + M) where N and M are the lengths of the two linked lists
        // Space Complexity: O(N) where N is the length of the first linked list
        java.util.HashSet<Node> visitedNodes = new java.util.HashSet<>();
        
        Node temp1 = head1;
        while (temp1 != null) {
            visitedNodes.add(temp1);
            temp1 = temp1.next;
        }
        
        Node temp2 = head2;
        while (temp2 != null) {
            if (visitedNodes.contains(temp2)) {
                return temp2; // Intersection found
            }
            temp2 = temp2.next;
        }
        
        return null; // No intersection found
    }

    public static Node getIntersectionNodeUsingDistance(Node head1, Node head2) {
        // Time Complexity: O(N + M) where N and M are the lengths of the two linked lists
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        int len1 = 0, len2 = 0;
        
        Node temp1 = head1;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        
        Node temp2 = head2;
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        
        // Collision point is at the same distance from the end of both lists
        int diff = Math.abs(len1 - len2);
        Node longer = len1 > len2 ? head1 : head2;
        Node shorter = len1 > len2 ? head2 : head1;
        
        // Move the pointer of the longer list ahead by the difference in lengths
        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        
        // Traverse both lists together to find the intersection
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return longer; // Intersection found
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return null; // No intersection found
    }

    public static Node getIntersectionTwoPointers(Node head1, Node head2) {
        // Time Complexity: O(N + M) where N and M are the lengths of the two linked lists
        // Space Complexity: O(1) since we are not using any extra space except for pointers
        if (head1 == null || head2 == null) return null;

        Node a = head1;
        Node b = head2;

        // Traverse both lists, switching to the other list when reaching the end
        while (a != b) {
            a = (a == null) ? head2 : a.next;
            b = (b == null) ? head1 : b.next;
        }

        return a; // Either intersection node or null if no intersection
    }

    public static void main(String[] args) {
        Node head1 = convertArrayToLinkedList(new int[]{1, 2, 3, 4, 5});
        Node head2 = convertArrayToLinkedList(new int[]{6, 7, 8});
        
        // Creating an intersection
        Node intersection = head1.next.next; // Node with value 3
        head2.next.next = intersection; // 8 -> 3

        Node intersectionNode = getIntersectionNodeHashing(head1, head2);
        if (intersectionNode != null) {
            System.out.println("Hashing Intersection at node with value: " + intersectionNode.data);
        } else {
            System.out.println("No intersection found.");
        }

        Node intersectionNodeUsingDistance = getIntersectionNodeUsingDistance(head1, head2);
        if (intersectionNodeUsingDistance != null) {
            System.out.println("Distancing Intersection at node with value: " + intersectionNodeUsingDistance.data);
        } else {
            System.out.println("No intersection found.");
        }

        Node intersectionNodeTwoPointers = getIntersectionTwoPointers(head1, head2);
        if (intersectionNodeTwoPointers != null) {
            System.out.println("Two Pointers Intersection at node with value: " + intersectionNodeTwoPointers.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
    
}
