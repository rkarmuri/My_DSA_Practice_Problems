public class RequirementsForBT {
    
    public static boolean uniqueBinaryTree(int a, int b){
        // To constructa unique binary tree, we must inorder traversal of the tree
        // We cannot have 2 same traversals among inorder, preorder and postorder
        // Inorder traversal must be followed by either preorder or postorder traversal
        if((a==b) || (a == 1) && (b == 3) || (a == 3) && (b ==1)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 2; // Inorder
        int b = 1; // Preorder
        int c = 3; // Postorder
        if(uniqueBinaryTree(a,b)){
            System.out.println("Unique binary tree can be constructed with the given traversals: "+ a +", "+b);
        } else {
            System.out.println("Unique binary tree cannot be constructed with the given traversals: "+ a +", "+b);
        }

        if(uniqueBinaryTree(a,c)){
            System.out.println("Unique binary tree can be constructed with the given traversals: "+ a +", "+c);
        } else {
            System.out.println("Unique binary tree cannot be constructed with the given traversals: "+ a +", "+c);
        }

        if(uniqueBinaryTree(b,c)){
            System.out.println("Unique binary tree can be constructed with the given traversals: "+ b +", "+c);
        } else {
            System.out.println("Unique binary tree cannot be constructed with the given traversals: "+ b +", "+c);
        }
    }
}
