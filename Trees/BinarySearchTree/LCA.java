package Trees;

public class LCA {
    public Node lowestCommonAncestor(Node root, int p, int q) {
        if(root == null)    return null;

        int curr = root.data;
        if(curr > p && curr > q){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(curr < p && curr < q){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(8);

        LCA sol = new LCA();

        // Find the LCA of nodes with values 5 and 8
        Node ans = sol.lowestCommonAncestor(root, 5, 8);
        if (ans != null) {
            System.out.println("LCA(5, 8) = " + ans.data);
        } else {
            System.out.println("LCA(5, 8) is not present in the tree");
        }
    }
}
