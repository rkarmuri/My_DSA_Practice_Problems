package Trees;


public class InsertNode {
    public static Node insertBSTNode(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data > val){
            root.left = insertBSTNode(root.left, val);
        }
        else if(root.data < val){
            root.right = insertBSTNode(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        
        InsertNode sol = new InsertNode();
        int val = 5;

        Node newRoot = sol.insertBSTNode(root, val);

        printBST(newRoot);
    }

    public static void printBST(Node root) {
        if (root == null) return;
        printBST(root.left);
        System.out.print(root.data + " ");
        printBST(root.right);
    }
}
