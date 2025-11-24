package Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import java.util.LinkedList;

public class BurnNodes {
    public int amountOfTime(Node root, int start) {
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node startNode = null;
        q.offer(root);

        while(!q.isEmpty()){
            Node node = q.poll();
            if (node.data == start) {
                startNode = node;
            }
            if(node.left != null){
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }

        Set<Node> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
        
                if(node.left != null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    q.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            time++;
        }

        return time - 1;
    }

    public static void main(String[] args) {
        BurnNodes sol = new BurnNodes();

        // Create the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int start = 4;

        // Get the time to burn the tree
        int result = sol.amountOfTime(root, start);
        System.out.println("Time to burn the tree: " + result);
    }
}
