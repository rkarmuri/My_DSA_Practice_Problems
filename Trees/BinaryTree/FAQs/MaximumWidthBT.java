package Trees;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

class PairBT{
    Node node;
    int level;

    PairBT(Node node, int level){
        this.node = node;
        this.level = level;
    }

    public Node getKey(){
        return node;
    }

    public int getValue(){
        return level;
    }
}

public class MaximumWidthBT {
    public int widthOfBinaryTree(Node root) {
        if(root == null)    return 0;
        int ans = 0;
        Queue<PairBT> q = new LinkedList<>();

        q.offer(new PairBT(root, 1));

        while(!q.isEmpty()){
            int size = q.size();
            int prevLevel = q.peek().getValue();

            int first = 0, last = 0;

            for(int i = 0; i < size; i++){
                int cur_id = q.peek().getValue() - prevLevel;
                Node node = q.peek().getKey();
                q.poll();

                if(i == 0)  first = cur_id;
                if(i == size - 1)   last = cur_id;

                if(node.left != null){
                    q.offer(new PairBT(node.left, 2*cur_id + 1));
                }

                if(node.right != null){
                    q.offer(new PairBT(node.right, 2*cur_id + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        MaximumWidthBT sol = new MaximumWidthBT();

        int maxWidth = sol.widthOfBinaryTree(root);

        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}
