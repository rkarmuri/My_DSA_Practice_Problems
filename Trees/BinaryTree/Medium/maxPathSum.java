package Trees;

public class maxPathSum {
    public static int maxPath(Node root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(Node root, int maxValue[]) {
        if(root==null)  return 0;
        // If there are negative values, we ignore them
        int leftDepth = Math.max(0,maxPathDown(root.left, maxValue));
        int rightDepth = Math.max(0,maxPathDown(root.right, maxValue));
        // At each node, i.e., Umbrella. Add left subtree, righttree and node value
        maxValue[0] = Math.max(maxValue[0],leftDepth+rightDepth+root.data);
        return Math.max(leftDepth,rightDepth) + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int res = maxPath(root);
        System.out.println("The maximum Path sum of the binary tree is: "+res);
    }
}
