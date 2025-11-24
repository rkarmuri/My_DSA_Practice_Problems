package Trees;

import java.util.HashMap;

public class ConstructBTPIn {
    // Time Complexity: O(n), Space Complexity: O(n)
    public static Node constructTree(int[] postOrder, int[] inOrder) {
        int n = postOrder.length - 1, m = inOrder.length - 1;
        // We need a HashMap to store the indexes and the values of the tree nodes
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i <= m; i++) {
            inMap.put(inOrder[i], i);
        }
        Node root = constructTreeHelper(postOrder, 0, n, inOrder, 0, m, inMap);

        return root;
    }

    private static Node constructTreeHelper(int[] postOrder, int postStart, int postEnd,
                                            int[] inOrder, int inStart, int inEnd,
                                            HashMap<Integer, Integer> inMap) {
                                
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        Node root = new Node(postOrder[postEnd]);
        int inRootIndex = inMap.get(root.data);
        int numsRight = inEnd - inRootIndex;

        root.left = constructTreeHelper(postOrder, postStart, postEnd - numsRight - 1,
                                        inOrder, inStart, inRootIndex - 1, inMap);
        root.right = constructTreeHelper(postOrder, postEnd - numsRight, postEnd - 1,
                                         inOrder, inRootIndex + 1, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};

        Node root = constructTree(postOrder, inOrder);

        System.out.print("Inorder traversal of constructed tree: ");
        printInOrder(root);
        System.out.println();
    }

    private static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
}
