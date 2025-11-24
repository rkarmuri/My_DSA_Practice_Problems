package Trees;

public class diameterOfBinaryTree {
    // Time Complexity: O(n), Space Complexity: O(h)
    // We must use an array instead of a simple integer to store the diameter
    // because we need to update its value inside the recursive calls.
    // If we use a simple integer, it would be passed by value, and changes made
    // to it inside the recursive calls would not be reflected outside those calls.
    public static int diameter(Node root) {
        int[] diam = new int[1]; // to store the maximum diameter found
        height(root,diam);
        return diam[0];
    }

    public static int height(Node root, int[] diam) {
        if(root==null)  return 0;

        int leftDepth = height(root.left, diam);
        int rightDepth = height(root.right, diam);
        // Store the maximum height found so far in diam[0]
        diam[0] = Math.max(diam[0], leftDepth+rightDepth);
        return Math.max(leftDepth, rightDepth)+1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int res = diameter(root);
        System.out.println("The diameter of the binary tree is: "+res);
    }
}
