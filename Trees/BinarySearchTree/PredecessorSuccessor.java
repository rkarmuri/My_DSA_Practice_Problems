package Trees;

import java.util.ArrayList;
import java.util.List;

public class PredecessorSuccessor {
    List<Integer> succPredBST(Node root, int key) {
        Node predecessor = null;
        Node successor = null;
        Node curr = root;

        while (curr != null) {
            if (key > curr.data) {
                predecessor = curr;
                curr = curr.right;
            } else if(key < curr.data){
                successor = curr;
                curr = curr.left;
            } else {
                if(curr.left != null){
                    Node node = curr.left;
                    while(node.right != null){
                        node = node.right;
                    }
                    predecessor = node;
                }
                if(curr.right != null){
                    Node node = curr.right;
                    while(node.left != null){
                        node = node.left;
                    }
                    successor = node;
                }
                break;
            }
        }
        int predVal = (predecessor != null ? predecessor.data : -1);
        int succVal = (successor != null ? successor.data : -1);

        List<Integer> res = new ArrayList<>();
        res.add(predVal);
        res.add(succVal);

        return res;
    }

    public static void main(String[] args) {
        // Example usage
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        PredecessorSuccessor sol = new PredecessorSuccessor();
        System.out.println(sol.succPredBST(root, 12)); // Output: [10, 15]
    }
}
