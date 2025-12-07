public class RemoveAllAdjacentDups {
    public String removeDuplicates(String s){
        // Time Complexity: O(n), Space Complexity: O(n)
        char[] stack = new char[s.length()];
        int top = -1; // Initialize top of stack

        for(char ch : s.toCharArray()){
            if(top >= 0 && stack[top] == ch){
                top--; // Pop the top element
            } else {
                stack[++top] = ch; // Push current character onto stack
            }
        }
        return new String(stack, 0, top + 1);
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDups remover = new RemoveAllAdjacentDups();
        String input = "abbaca";
        String result = remover.removeDuplicates(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result); // Expected Output: "ca"
    }
}
