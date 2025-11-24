package Trees;

public class CheckSymmetricTree {
    public static boolean isSymmetric(Node root) {
        // Time Complexity: O(n), Space Complexity: O(h)
        if(root==null)  return true;
        return isMirror(root.left,root.right);
    }

    public static boolean isMirror(Node left, Node right) {
        if(left==null || right==null)   return left==right;

        return (left.data==right.data) && isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean res = isSymmetric(root);
        System.out.println("Is the given tree symmetric? "+res);
    }
}
