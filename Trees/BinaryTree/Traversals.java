package Trees;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left,right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    Node node;
    int state;

    public Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

class Traversals {
    public static void inOrder(Node root) {
        if (root == null) return;
        
        inOrder(root.left);
        System.out.print(root.data + " ");  // Print value of the current node
        inOrder(root.right);
    }

    public static List<Integer> inOrderIter(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        
        while(!st.isEmpty() || root!=null){
            // Reach the leftmost node of the current Node
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            // Current must be NULL at this point
            root = st.pop();
            res.add(root.data); // Add the node data to result
            // Visit the right subtree
            root = root.right;
        }

        return res;
    }

    public static void preOrder(Node root) {
        if(root==null)  return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static List<Integer> preOrderIter(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        if(root==null)  return res;

        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            res.add(root.data);
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
        }

        return res;
    }

    public static void postOrder(Node root) {
        if(root==null)  return;
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static List<Integer> postOrderIter2Stacks(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();

        if(root==null)  return res;
        st1.push(root);

        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left!=null){
                st1.push(root.left);
            }
            if(root.right!=null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().data);
        }

        return res;
    }

    public static List<Integer> postOrderIter1Stack(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();

        st.push(root);
        while(!st.isEmpty()){
            Node curr = st.pop();
            res.add(curr.data);
            if(curr.left!=null){
                st.push(curr.left);
            }
            if(curr.right!=null){
                st.push(curr.right);
            }
        }

        // Reverse the result to get the correct post-order
        Collections.reverse(res);

        return res;
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)  return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<size; i++){
                Node curr = queue.poll();
                level.add(curr.data);

                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    // Reverse the level order traversal from bottom to top
    public static List<List<Integer>> reverseLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.data);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // Adding index 0 at every iteration will automatically
            // push the previous levels to the right in the list and create a reverse order.
            res.add(0, level); 
        }
        return res;
    }

    public static void preInPostIter(Node root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root,1));

        while(!st.isEmpty()){
            Pair p = st.pop();
            Node node = p.node;
            int state = p.state;

            if(state==1){
                // Pre order
                pre.add(node.data); // Store the node data in pre-order list
                p.state++; // Increment the state of the current node
                st.push(p); // Update the state of the current node in the stack

                // Go to left child
                if(node.left!=null){
                    st.push(new Pair(node.left,1)); // Push the left child with state 1
                }
            }   else if(state==2) {
                // In-order
                in.add(node.data); // Store the node data in in-order list
                p.state++; // Increment the state of the current node
                st.push(p); // Update the state of the current node in the stack

                // Go to right-child
                if(node.right!=null){
                    st.push(new Pair(node.right,1)); // Push the right child with state 1
                }
            }   else {
                // Post-order
                post.add(node.data); // Store the node data in post-order list
            }
        }
    }

    // Morris Inorder Traversal (O(1) space)
    public static List<Integer> morrisInOrder(Node root) {
        List<Integer> inorder = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            // If there is no left child, visit the current node and go to the right child
            if (curr.left == null) {
                inorder.add(curr.data);
                curr = curr.right;
            } else {
                Node pre = curr.left; // Find the inorder predecessor of current
                // To find the predecessor, keep going to the rightmost node of the left subtree
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                // Make current as the right child of its inorder predecessor
                if (pre.right == null) {
                    pre.right = curr; // Create a temporary thread to the inorder successor 
                    curr = curr.left; // Move the current to its left child
                } else {
                    pre.right = null; // Remove the temporary thread
                    inorder.add(curr.data); // Visit the current node
                    curr = curr.right; // Move to the right child
                }
            }
        }

        return inorder;
    }

    // Morris Preorder Traversal (O(1) space) - Optional
    public static List<Integer> morrisPreOrder(Node root) {
        List<Integer> preorder = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            // If there is no left child, visit the current node and go to the right child
            if (curr.left == null) {
                preorder.add(curr.data);
                curr = curr.right;
            } else {
                Node pre = curr.left; // Find the inorder predecessor of current
                // To find the predecessor, keep going to the rightmost node of the left subtree
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                // Make current as the right child of its inorder predecessor
                if (pre.right == null) {
                    preorder.add(curr.data); // Visit the current node before creating the thread
                    pre.right = curr; // Create a temporary thread to the inorder successor 
                    curr = curr.left; // Move the current to its left child
                } else {
                    pre.right = null; // Remove the temporary thread
                    curr = curr.right; // Move to the right child
                }
            }
        }

        return preorder;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        System.out.print("Inorder traversal is: ");
        inOrder(root);  
        System.out.println();
        System.out.print("Preorder traversal is: ");
        preOrder(root);  
        System.out.println();
        System.out.print("Postorder traversal is: ");
        postOrder(root);  
        System.out.println();
        List<Integer> inResult = inOrderIter(root);
        System.out.println("Iterative inorder traversal is: "+inResult);
        List<Integer> preResult = preOrderIter(root);
        System.out.println("Iterative preorder traversal is: "+preResult);
        List<Integer> postResult1 = postOrderIter2Stacks(root);
        System.out.println("Iterative postorder traversal using 2 stacks is: "+postResult1);
        List<Integer> postResult2 = postOrderIter1Stack(root);
        System.out.println("Iterative preorder traversal using 1 stack is: "+postResult2); 
        List<List<Integer>> levelOrderResult = levelOrder(root);
        System.out.println("Level-order traversal is: "+levelOrderResult);
        List<List<Integer>> reverseLevelOrderResult = reverseLevelOrder(root);
        System.out.println("Reverse Level-order traversal is: "+reverseLevelOrderResult);
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preInPostIter(root, pre, in, post);
        System.out.println("Pre-order single traversal: "+ pre);
        System.out.println("In-order single traversal: "+ in);
        System.out.println("Post-order single traversal: "+ post);

        List<Integer> morrisInorderResult = morrisInOrder(root);
        System.out.println("Morris Inorder traversal is: " + morrisInorderResult);

        List<Integer> morrisPreorderResult = morrisPreOrder(root);
        System.out.println("Morris Preorder traversal is: " + morrisPreorderResult);
    }
}

