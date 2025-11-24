package Trees;

import java.util.HashMap;

public class ConstructBTPreIn {
    // Time Complexity: O(n), Space Complexity: O(n)
    public static Node constructTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length - 1, m = inOrder.length - 1;
        // We need a HashMap to store the indexes and the values of the tree nodes
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i <= m; i++) {
            inMap.put(inOrder[i], i);
        }
        Node root = constructTreeHelper(preOrder, 0, n, inOrder, 0, m, inMap);

        return root;
    }

    private static Node constructTreeHelper(int[] preOrder, int preStart, int preEnd,
                                            int[] inOrder, int inStart, int inEnd,
                                            HashMap<Integer, Integer> inMap) {
                                
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        Node root = new Node(preOrder[preStart]);
        int inRootIndex = inMap.get(root.data);
        int numsLeft = inRootIndex - inStart;

        root.left = constructTreeHelper(preOrder, preStart + 1, preStart + numsLeft,
                                        inOrder, inStart, inRootIndex - 1, inMap);
        root.right = constructTreeHelper(preOrder, preStart + numsLeft + 1, preEnd,
                                         inOrder, inRootIndex + 1, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};

        Node root = constructTree(preOrder, inOrder);

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
