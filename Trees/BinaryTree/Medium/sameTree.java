package Trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class sameTree {
    public boolean isIdentical(Node node1, Node node2) {
        // If both nodes are NULL,they are identical
        // Time Complexity: O(n), Space Complexity: O(h)
        if (node1 == null && node2 == null) {
            return true;
        }
        // If only one of the nodes is NULL, they are not identical
        if (node1 == null || node2 == null) {
            return false;
        }
        // Check if the current nodes have the same data value
        // and recursively check their left and right subtrees
        return ((node1.data == node2.data)
                && isIdentical(node1.left, node2.left)
                && isIdentical(node1.right, node2.right));
    }
    
    // Iterative approach DFS, Time Complexity: O(n), Space Complexity: O(h)
    public boolean isIdenticalDFS(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }  
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node1);
        stack2.push(node2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Node curr1 = stack1.pop();
            Node curr2 = stack2.pop();

            if (curr1.data != curr2.data) {
                return false;
            }
            if (curr1.right != null && curr2.right != null) {
                stack1.push(curr1.right);
                stack2.push(curr2.right);
            } else if (curr1.right != null || curr2.right != null) {
                return false;
            }
            if (curr1.left != null && curr2.left != null) {
                stack1.push(curr1.left);
                stack2.push(curr2.left);
            } else if (curr1.left != null || curr2.left != null) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Iterative approach BFS
    public boolean isIdenticalBFS(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.offer(node1);
        q2.offer(node2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node curr1 = q1.poll();
            Node curr2 = q2.poll();

            if (curr1 == null && curr2 == null) {
                continue;
            }
            if (curr1 == null || curr2 == null) {
                return false;
            }

            if (curr1.data != curr2.data) {
                return false;
            }
            
            q1.offer(curr1.left);
            q1.offer(curr1.right);
            q2.offer(curr2.left);
            q2.offer(curr2.right);
        }

        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        // Node1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        // Node2
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        sameTree solution = new sameTree();

        if (solution.isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }

        if (solution.isIdenticalBFS(root1, root2)) {
            System.out.println("The binary trees are identical (BFS).");
        } else {
            System.out.println("The binary trees are not identical (BFS).");
        }

        if (solution.isIdenticalDFS(root1, root2)) {
            System.out.println("The binary trees are identical (DFS).");
        } else {
            System.out.println("The binary trees are not identical (DFS).");
        }
    }
}
                            
                        
