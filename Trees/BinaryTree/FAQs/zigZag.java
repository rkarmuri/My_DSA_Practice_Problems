package Trees;

import java.util.*;

public class zigZag {
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Use LinkedList to facilitate adding elements at both ends
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                // Add node to the level list based on traversal direction
                if (leftToRight) {
                    levelList.add(currentNode.data); // Adds to end for left-to-right order
                } else {
                    levelList.addFirst(currentNode.data); // Adds to front for right-to-left order
                }

                // Add child nodes to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Toggle direction for the next level
            leftToRight = !leftToRight;
            result.add(levelList);
        }
        return result;
    }

    static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> res = zigzagLevelOrder(root);
        printResult(res);;

    }
}

