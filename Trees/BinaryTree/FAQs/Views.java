package Trees;

import java.util.TreeMap;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Pairs{
    Node node;
    int hd;

    public Pairs(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class Views {
    public static void printTopView(Node root) {
        // Time Complexity: O(n), Space Complexity: O(h)
        if(root==null)  return;

        // Create a map to store the top view nodes
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pairs> queue = new LinkedList<>();
        queue.offer(new Pairs(root, 0));

        while(!queue.isEmpty()) {
            Pairs curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // If this is the first node at its horizontal distance, add it to the map
            if(!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            // Continue with the BFS
            if(node.left!=null) {
                queue.offer(new Pairs(node.left, hd-1));
            }
            if(node.right!=null) {
                queue.offer(new Pairs(node.right, hd+1));
            }
        }

        // Print the top view
        System.out.println("Top view of the tree:");
        for(int key : topViewMap.values()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    // Bottom View can be implemented similarly by updating the map for every node encountered at each horizontal distance.
    public static void printBottomView(Node root) {
        if(root==null)  return;

        TreeMap<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<Pairs> queue = new LinkedList<>();
        queue.offer(new Pairs(root, 0));

        while(!queue.isEmpty()) {
            Pairs curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // Update the map for every node encountered at each horizontal distance
            bottomViewMap.put(hd, node.data);

            if(node.left!=null) {
                queue.offer(new Pairs(node.left, hd-1));
            }
            if(node.right!=null) {
                queue.offer(new Pairs(node.right, hd+1));
            }
        }

        // Print the bottom view
        System.out.println("Bottom view of the tree:");
        for(int key : bottomViewMap.values()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    // Recursive Right View
    public static List<Integer> rightView(Node root){
        List<Integer> ans = new ArrayList<>();

        recursionRight(root, 0, ans);
        return ans;
    }

    private static void recursionRight(Node root, int level, List<Integer> ans){
        if(root == null)    return;

        if(ans.size() == level){
            ans.add(root.data);
        }

        recursionRight(root.right, level + 1, ans);
        recursionRight(root.left, level + 1, ans);
    }

    // Recursive Left view
    public static List<Integer> leftView(Node root){
        List<Integer> ans = new ArrayList<>();

        recursionLeft(root, 0, ans);
        return ans;
    }

    private static void recursionLeft(Node root, int level, List<Integer> ans){
        if(root == null)    return;

        if(ans.size() == level){
            ans.add(root.data);
        }

        recursionLeft(root.left, level + 1, ans);
        recursionLeft(root.right, level + 1, ans);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        printTopView(root);
        printBottomView(root);

        Views solution = new Views();

        // Get the Right View traversal
        List<Integer> rv = solution.rightView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rv) {
            System.out.print(node + " ");
        }
        System.out.println();

        // Get the Left View traversal
        List<Integer> lv = solution.leftView(root);

        // Print the result for Left View
        System.out.print("Left View Traversal: ");
        for (int node : lv) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
