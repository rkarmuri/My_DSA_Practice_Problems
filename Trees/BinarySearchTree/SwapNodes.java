package Trees;

public class SwapNodes {
    private Node prev = null, first = null, middle = null, last = null;
    void recoverTree(Node root) {
        if(root == null)    return;
        inorder(root);
        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if(first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    public void inorder(Node node){
        if(node == null)    return;
        inorder(node.left);
        if(prev != null && prev.data > node.data){
            if(first == null){
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }

        prev = node;

        inorder(node.right);
    }

    public static void main(String[] args) {
        // Example input tree: [1, 3, null, null, 2]
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);
        root.right = new Node(4);
        root.right.right = new Node(5);

        // Solution instance
        SwapNodes sol = new SwapNodes();
        sol.recoverTree(root);

        // Helper function to print inorder traversal of the tree
        inorderPrint(root);
    }

    private static void inorderPrint(Node root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }
}