package Trees;

import java.util.Queue;
import java.util.Stack;

class Pair { // To implement DFS iteratively
    Node node;
    int depth;

    Pair(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
public class MaximumDepth {
    // Recursive approach and DFS, Time Complexity: O(n), Space Complexity: O(h)
    public static int maxDepth(Node root) {
        if(root==null)  return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }

    // Iterative approach DFS, Time Complexity: O(n), Space Complexity: O(h)
    public static int maxDepthDFS(Node root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            Node currentNode = current.node;
            int currentDepth = current.depth;

            if (currentNode != null) {
                maxDepth = Math.max(maxDepth, currentDepth);

                if (currentNode.right != null) {
                    stack.push(new Pair(currentNode.right, currentDepth + 1));
                }
                if (currentNode.left != null) {
                    stack.push(new Pair(currentNode.left, currentDepth + 1));
                }
            }
        }
        return maxDepth;
    }

    // Level traversal which is iterative approach and uses BFS
    // Time Complexity: O(n), Space Complexity: O(w) where w is the maximum width of the tree
    public static int maxDepthIter(Node root) {
        if(root==null)  return 0;
        Queue<Node> q = new java.util.LinkedList<>();
        q.offer(root);
        int result = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(node.left!=null)   q.offer(node.left);
                if(node.right!=null)  q.offer(node.right);
            }
            result++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int res = maxDepth(root);
        System.out.println("Maximum depth of the binary tree using Recursion is: "+res);
        int res2 = maxDepthIter(root);
        System.out.println("Maximum depth of the binary tree using Iteration is: "+res2);
    }
}
