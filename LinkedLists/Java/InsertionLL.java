package LinkedLists.Java;

public class InsertionLL {
    private static Node convertArrayToLL(int[] arr){
        if(arr.length==0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    
    private static Node insertHead(Node head, int item){
        if(head==null){
            Node tmp = new Node(item);
            return tmp;
        }
        Node tmp = new Node(item);
        tmp.next = head;
        head = tmp;
        return head;
    }

    private static Node insertTail(Node head, int item){
        if(head==null){
            Node tmp = new Node(item);
            return tmp;
        }
        Node tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        Node tail = new Node(item);
        tmp.next = tail;
        return head;
    }

    private static Node insertValueAfterItem(Node head, int val, int item){
        Node tmp = head;
        Node newNode = new Node(val);
        while(tmp!=null){
            if(tmp.data==item){
                newNode.next = tmp.next;
                tmp.next = newNode;
                break;
            }
            tmp = tmp.next;
        }
        return head;
    }
    
    private static Node insertValueAfterPosition(Node head, int val, int pos) {
        int lengthLL = lengthOfLL(head);
        if (pos == 0) {
            return insertHead(head, val);
        }
        else if(pos>=lengthLL){
            return insertTail(head,val);
        }
        Node tmp = head;
        int cnt = 0;
        Node newNode = new Node(val);
        
        while(tmp!=null){
            if(cnt==pos-1){
               newNode.next = tmp.next;
               tmp.next = newNode;
               break;
            }
            cnt += 1;
            tmp = tmp.next;
        }
        return head;
    }
    
    private static int lengthOfLL(Node head){
        if(head==null) {
            return 0;
        }
        int length = 0;
        while(head!=null){
            length+=1;
            head = head.next;
        }
        return length;
    }

    private static void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
    }
    
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        Node head = convertArrayToLL(arr);
        int item = 9;
        int item2 = 10;
        int val = 6;
        int item3 = 3;
        int val2 = 8;
        int pos = 2;
        Node newHead = insertHead(head,item);
        System.out.print("Linked List after inserting node at head: ");
        printLinkedList(newHead);
        System.out.println("null");
        Node newTail = insertTail(newHead,item2);
        System.out.print("Linked List after inserting node at tail: ");
        printLinkedList(newTail);
        System.out.println("null");
        Node newVal = insertValueAfterItem(newTail,val,item3);
        System.out.print("Linked List after inserting node after the node value "+item3+" is: ");
        printLinkedList(newVal);
        System.out.println("null");
        Node newPosVal = insertValueAfterPosition(newTail,val2,pos);
        System.out.print("Linked List after inserting node after the position "+pos+" is: ");
        printLinkedList(newPosVal);
        System.out.println("null");
    }
}
