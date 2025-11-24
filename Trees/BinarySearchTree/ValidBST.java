package Trees;

public class ValidBST{
    // Intution: We need to check if the left and right trees are within the range
    public boolean isValidBST(Node root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean helper(Node root, long max, long min){
        if(root == null)    return true;
        if(root.data >= max || root.data <= min) return false;
        return helper(root.left, root.data, min) && helper(root.right, max, root.data);
    }
    
    public  static void main (String args[]){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        ValidBST sol = new ValidBST();

        boolean res = sol.isValidBST(root);

        System.err.println("Is the given BST valid?: "+ res);

    }
        
}
