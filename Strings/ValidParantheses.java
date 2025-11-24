public class ValidParantheses {
    public boolean isValid(String s) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) { 
                return false;
            }
        }
        return stack.isEmpty(); // if stack is empty, all parentheses were matched else false
    }

    // Using HashMap
    public boolean isValidUsingHashMap(String s) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        java.util.Stack<Character> stack = new java.util.Stack<>();
        java.util.Map<Character, Character> map = new java.util.HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParantheses vp = new ValidParantheses();
        System.out.println(vp.isValid("()")); // true
        System.out.println(vp.isValid("()[]{}")); // true
        System.out.println(vp.isValid("(]")); // false
        System.out.println(vp.isValid("([)]")); // false
        System.out.println(vp.isValid("{[]}")); // true
        System.out.println(vp.isValidUsingHashMap("((()))")); // true
    }
}
