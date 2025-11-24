package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBT {
    public static String serialize(Node root) {
        if(root == null){
            return "";
        }

        Queue<Node> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr == null){
                sb.append("N,");
            } else {
                sb.append(curr.data).append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return sb.toString();
    }

    public static Node deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }

        String[] values = data.split(",");
        if(values.length == 0 || values[0].equals("N")){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);

        for(int i = 1; i < values.length; i++){
            Node curr = queue.poll();

            if(!values[i].equals("N")){
                curr.left = new Node(Integer.parseInt(values[i]));
                queue.add(curr.left);
            }
            i++;

            if(i < values.length && !values[i].equals("N")){
                curr.right = new Node(Integer.parseInt(values[i]));
                queue.add(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        String serializedData = serialize(root);
        System.out.println("Serialized tree: " + serializedData);
        Node deserializedRoot = deserialize(serializedData);
        System.out.print("Deserialized tree: ");
        printLevelOrder(deserializedRoot);
    }

    public static void printLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                System.out.print("null ");
                continue;
            }
            System.out.print(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }
        System.out.println();
}

}
