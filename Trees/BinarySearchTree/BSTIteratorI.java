package Trees;

import java.util.Stack;

public class BSTIteratorI {
    private Stack<Node> st = new Stack<>();
    public BSTIteratorI(Node root) {
        pushAll(root);
    }
    
    public int next() {
        Node node = st.pop();
        if(node.right != null){
            pushAll(node.right);
        }

        return node.data;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushAll(Node root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);

        BSTIteratorI iterator = new BSTIteratorI(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}