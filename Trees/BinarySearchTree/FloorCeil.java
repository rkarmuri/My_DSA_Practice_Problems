package Trees;

import java.util.ArrayList;
import java.util.List;

public class FloorCeil {
    public List<Integer> floorCeilOfBST(Node root, int key) {
        List<Integer> res = new ArrayList<>();
        int floor = -1, ceil = -1;

        Node current = root;
        while(current != null){
            if(current.data == key){
                floor = current.data;
                break;
            }
            if(current.data < key){
                floor = current.data;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        res.add(floor);

        current = root;
        while(current != null){
            if(current.data == key){
                ceil = current.data;
                break;
            }
            if(current.data > key){
                ceil = current.data;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        res.add(ceil);
        return res;
    }

    public static void main(String[] args) {
        // Creating a sample BST
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        FloorCeil sol = new FloorCeil();

        int key = 11;

        List<Integer> result = sol.floorCeilOfBST(root, key);
        System.out.println("Floor: " + result.get(0) + ", Ceil: " + result.get(1));
    }
}
