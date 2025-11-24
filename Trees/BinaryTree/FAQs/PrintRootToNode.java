package Trees;

import java.util.ArrayList;
import java.util.List;


public class PrintRootToNode {
    public List<List<Integer>> allRootToLeaf(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        findLeafPath(root, result, new ArrayList<>());

        return result;
    }

    public void findLeafPath(Node root, List<List<Integer>> result, List<Integer> currentPath){
        if(root == null)    return;

        currentPath.add(root.data);

        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(currentPath));
        } else {
            findLeafPath(root.left, result, currentPath);
            findLeafPath(root.right, result, currentPath);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        PrintRootToNode printer = new PrintRootToNode();
        List<List<Integer>> paths = printer.allRootToLeaf(root);

        System.out.println("All root-to-leaf paths:");
        for(List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
