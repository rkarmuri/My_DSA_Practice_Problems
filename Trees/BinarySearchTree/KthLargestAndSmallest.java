package Trees;

import java.util.ArrayList;
import java.util.List;

public class KthLargestAndSmallest {
    private int cnt1 = 0, cnt2 = 0, largest = 0, smallest = 0;
    public List<Integer> kLargesSmall(Node root, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root,k);
        reverseInorder(root, k);
        result.add(smallest);
        result.add(largest);
        return result;
    }

    public void inorder(Node root, int k){
        if(root == null)    return;
        inorder(root.left, k);
        cnt1++;
        if(cnt1 == k)   smallest = root.data;
        inorder(root.right, k);
    }

    public void reverseInorder(Node root, int k){
        if(root == null)    return;
        reverseInorder(root.right, k);
        cnt2++;
        if(cnt2 == k)   largest = root.data;
        reverseInorder(root.left, k);
    }

    public static void main(String[] args) {
        // Constructing the tree: [3, 1, 4, null, 2]
        Node root = new Node(3);
        root.left = new Node(1);
        root.left.right = new Node(2);
        root.right = new Node(4);

        KthLargestAndSmallest solution = new KthLargestAndSmallest();
        int k = 1;
        List<Integer> result = solution.kLargesSmall(root, k);

        // Output the result
        System.out.println(result); // Output: [1, 4]
    }
}
