package Trees;

public class ConstructBSTPreOrder {
    private int index = 0;
    public Node bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
    private Node build(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        Node root = new Node(preorder[index++]);

        root.left = build(preorder, root.data);
        root.right = build(preorder, bound);

        return root;
    }

    public static void main(String[] args) {
        ConstructBSTPreOrder solution = new ConstructBSTPreOrder();
        int[] preorder = {8, 5, 1, 7, 10, 12};

        Node root = solution.bstFromPreorder(preorder);

        // Print the constructed BST
        solution.inorderTraversal(root);
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
}
