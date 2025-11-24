package Trees;

import java.util.Stack;

class BSTIterator{
    private Stack<Node> st;
    private boolean reverse;
    public BSTIterator(Node root, boolean isReverse){
        st = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    public int next(){
        Node node = st.pop();
        if(reverse){
            pushAll(node.left);
        } else{
            pushAll(node.right);
        }

        return node.data;
    }
    public void pushAll(Node root){
        while(root != null){
            st.push(root);
            if(reverse){
                root = root.right;
            } else{
                root = root.left;
            }
        }
    }
}
public class TwoSumIV {
    public boolean twoSumBST(Node root, int k) {
        if(root == null)    return false;

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int l = left.next();
        int r = right.next();

        while(l < r){
            if(l + r == k)  return true;
            else if(l + r > k){
                r = right.next();
            }
            else {
                l = left.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Create the tree
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        // Create solution instance
        TwoSumIV solution = new TwoSumIV();
        int k = 9;
        
        // Check if there exist two elements in the BST such that their sum is equal to k
        boolean result = solution.twoSumBST(root, k);
        System.out.println(result ? "True" : "False");
    }
}
