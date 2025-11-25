public class CloneLL {
    private static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    private Node insertCopyInBetween(Node head){
        Node temp = head;

        while(temp!=null){
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        return head;
    }
    private void connectRandomPointers(Node head){
        Node temp = head;

        while(temp!=null){
            Node copyNode = temp.next;

            if(temp.random!=null){
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }

            temp = temp.next.next;
        }
    }
    private Node getDeepCopyList(Node head){
        Node dummyNode = new Node(-1);
        Node temp = head;
        Node res = dummyNode;

        while(temp!=null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
    public Node copyRandomList(Node head) {
        if(head==null)  return null;

        insertCopyInBetween(head);
        connectRandomPointers(head);

        return getDeepCopyList(head);
    }

    private void printLL(Node head){
        Node temp = head;
        while(temp!=null){
            int randomData = (temp.random != null) ? temp.random.data : -1;
            System.out.println("Node data: " + temp.data + ", Random points to: " + randomData);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        CloneLL cloneLL = new CloneLL();
        Node head = new Node(1);
        head.next = new Node(2);
        head.random = head.next;
        head.next.random = head;

        Node clonedHead = cloneLL.copyRandomList(head);
        cloneLL.printLL(clonedHead);
    }
}
