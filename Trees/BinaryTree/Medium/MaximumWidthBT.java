package Trees;

import java.util.Stack;

public class MaximumWidthBT {
    public static void flatten(Node root) {
        // Time Complexity: O(n), Space Complexity: O(h)
        if(root==null)  return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node curr = stack.pop();

            if(curr.right!=null)   stack.push(curr.right);
            if(curr.left!=null)    stack.push(curr.left);

            if(!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);
        System.out.print("Flattened tree: ");
        Node curr = root;
        while(curr!=null) {
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
        System.out.println();
    }
}
