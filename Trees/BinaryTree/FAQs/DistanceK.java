package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;


public class DistanceK {
    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left != null){
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);
        int currentDistance = 0;

        while(!q.isEmpty()){
            if(currentDistance == k){
                while(!q.isEmpty()){
                    result.add(q.poll().data);
                }

                return result;
            }

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
            currentDistance++;
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        root.left.right.right = new Node(7);
        root.left.right.left = new Node(8);
        Node target = root.left;
        int k = 2;

        DistanceK sol = new DistanceK();

        List<Integer> result = sol.distanceK(root, target, k);

        System.out.println("Nodes at distance " + k + " from target node are: " + result);
    }
}
