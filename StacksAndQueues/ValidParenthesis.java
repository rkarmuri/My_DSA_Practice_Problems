public class ValidParenthesis {
    public static boolean isValid(String s) {
        // Time Complexity: O(n), Space Complexity: O(n)
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "()";
        String test2 = "({[]})";
        String test3 = "(]";
        String test4 = "((()))";
        String test5 = "([)]";

        System.out.println("Is the input " + test1 + " valid? :" + isValid(test1)); // true
        System.out.println("Is the input " + test2 + " valid? :" + isValid(test2)); // true
        System.out.println("Is the input " + test3 + " valid? :" + isValid(test3)); // false
        System.out.println("Is the input " + test4 + " valid? :" + isValid(test4)); // true
        System.out.println("Is the input " + test5 + " valid? :" + isValid(test5)); // false
    }
}