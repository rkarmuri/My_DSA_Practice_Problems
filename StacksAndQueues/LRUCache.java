import java.util.HashMap;
import java.util.Map;
class LRUCache {
    private static class Node {
        public int key, val;
        public Node next, prev;
        
        // Constructors
        Node() {
            key = val = -1;
            next = prev = null;
        }

        Node(int k, int value) {
            key = k;
            val = value;
            next = prev = null;
        }
    }
    private Map<Integer, Node> mpp;
    private Node head;
    private Node tail;
    private int cap;

    public LRUCache(int capacity) {
       cap = capacity;
       mpp = new HashMap<>();
       head = new Node();
       tail = new Node();
       head.next = tail;
       tail.prev = head;
    }

    public int get(int key) {
       if(!mpp.containsKey(key)){
        System.out.println("Key: "+key+" not found in cache.");
        return -1;
       }

       Node node = mpp.get(key);
       int val = node.val;

       deleteNode(node);
       insertAfterHead(node);
       return val;
    }

    public void put(int key, int value) {
      if(mpp.containsKey(key)){
        Node node = mpp.get(key);
        node.val = value;

        deleteNode(node);
        insertAfterHead(node);
        return;
      }

      if(mpp.size() == cap){
        Node lastNode = tail.prev;
        mpp.remove(lastNode.key);
        deleteNode(lastNode);
      }

      Node newNode = new Node(key, value);
      mpp.put(key, newNode);
      insertAfterHead(newNode);
      System.out.println("Inserted key: "+key+" with value: "+value);
    }

    public void deleteNode(Node node){
      Node temp = node;

      Node prevNode = temp.prev;
      Node nextNode = temp.next;

      prevNode.next = nextNode;
      nextNode.prev = prevNode;
      temp.next = null;
      temp.prev = null;
    }

    public void insertAfterHead(Node node){
      Node nextNode = head.next;
      head.next = node;
      node.prev = head;
      node.next = nextNode;
      nextNode.prev = node;

    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1); // cache is {1=1}
        lru.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("The value for key 1 is: "+lru.get(1));    // return 1
        lru.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println("The value for key 2 is: "+lru.get(2));    // returns -1 (not found)
        lru.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
        System.out.println("The value for key 1 is: "+lru.get(1));    // return -1 (not found)
        System.out.println("The value for key 3 is: "+lru.get(3));    // return 3
        System.out.println("The value for key 4 is: "+lru.get(4));    // return 4
    }
}