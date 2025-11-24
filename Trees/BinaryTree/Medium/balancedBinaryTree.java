package Trees;

public class balancedBinaryTree {
    public static boolean isBalanced(Node root) {
        // Time Complexity: O(n), Space Complexity: O(n)
        return treeHeight(root)!=-1;
    }

    public static int treeHeight(Node root) {
        if(root==null)  return 0;
        
        int leftDepth = treeHeight(root.left);
        int rightDepth = treeHeight(root.right);

        if(leftDepth==-1||rightDepth==-1)   return -1;
        if(Math.abs(leftDepth-rightDepth)>1)    return -1;
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        boolean res = isBalanced(root);
        System.out.println("Is the given tree balanced? "+res);
    }
}
