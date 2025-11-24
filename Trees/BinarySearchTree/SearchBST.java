package Trees;

public class SearchBST {
    public Node searchBST(Node root, int val) {
        if(root == null || root.data == val)    return root;
        if(root.data < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        SearchBST sol = new SearchBST();
        Node result = sol.searchBST(root, 2);
        if (result != null) {
            System.out.println("Node found with value: " + result.data);
        } else {
            System.out.println("Node not found");
        }
    }
}