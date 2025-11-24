package LinkedLists.Java;

class Node {
    int data;
    Node next;
    
    // Constructor to create a new node with data and next pointer
    public Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }
    
    // Constructor to create a new node with only data, next pointer will be null
    public Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class LinkedList {
    private static Node convertArrayToLL(int[] arr){
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
    
    private static void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
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
    
    private static boolean searchLL(Node head, int item){
        if(head==null){
            return false;
        }
        
        while(head!=null){
            if(head.data == item){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        Node head = convertArrayToLL(arr);
        System.out.print("Linked List is: ");
        printLinkedList(head);
        System.out.println("null");
        int lengthLL = lengthOfLL(head);
        System.out.println("The length of the Linked List is: "+lengthLL);
        int item = 6;
        boolean searchElement = searchLL(head,item);
        System.out.println("Does the item "+item+" exists in the Linked List? "+searchElement);
    }
}