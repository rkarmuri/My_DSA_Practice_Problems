import java.util.HashMap;

public class ValidParantheses{
    // Intution: Maintain a range of possible open parentheses counts.
    // For '(', increase both min and max.
    // For ')', decrease both min and max.
    // For '*', decrease min (treating '*' as ')') and increase max (treating '*' as '(').
    // If at any point max < 0, return false.
    // At the end, if min is 0, return true.

    public static boolean isValid(String s) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int min = 0, max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else if (c == '*') {
                min--;
                max++;
            }
            if (max < 0) return false;
            min = Math.max(min, 0);
        }
        return min == 0;
    }

    // Using Dynamic Programming
    public static boolean isValidDP(String s) { 
        // Time Complexity: O(n^2)
        // Space Complexity: O(n^2)
        int index = 0, count = 0;

        return isValidHelper(s, index, count, new HashMap<>());
        
    }

    private static boolean isValidHelper(String s, int index, int count, HashMap<String, Boolean> memo) {
        if (index == s.length()) {
            return count == 0;
        }
        String key = index + "," + count;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        char c = s.charAt(index);
        boolean result;
        if (c == '(') {
            result = isValidHelper(s, index + 1, count + 1, memo);
        } else if (c == ')') {
            if (count == 0) {
                result = false;
            } else {
                result = isValidHelper(s, index + 1, count - 1, memo);
            }
        } else { // c == '*'
            result = isValidHelper(s, index + 1, count + 1, memo) || // Treat '*' as '('
                     isValidHelper(s, index + 1, count - 1, memo) || // Treat '*' as ')'
                     isValidHelper(s, index + 1, count, memo);       // Treat '*' as empty
        }
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "(*))";
        String s1 = "(*()";
        String s2 = "(*)))";
        String s3 = "((*)";
        String s4 = "*)";
        String s5 = "*)(";
        System.out.println("Is String "+s+" valid? "+isValid(s)); // Output: true
        System.out.println("Is String "+s1+" valid? "+isValid(s1)); // Output: true
        System.out.println("Is String "+s2+" valid? "+isValid(s2)); // Output: false
        System.out.println("Is String "+s3+" valid? "+isValid(s3)); // Output: true
        System.out.println("Is String "+s4+" valid? "+isValid(s4)); // Output: true
        System.out.println("Is String "+s5+" valid? "+isValid(s5)); // Output: false
        System.out.println("Using DP:");
        System.out.println("Is String "+s+" valid? "+isValidDP(s)); // Output: true
        System.out.println("Is String "+s1+" valid? "+isValidDP(s1)); // Output: true
        System.out.println("Is String "+s2+" valid? "+isValidDP(s2)); // Output: false
        System.out.println("Is String "+s3+" valid? "+isValidDP(s3)); // Output: true
        System.out.println("Is String "+s4+" valid? "+isValidDP(s4)); // Output: true
        System.out.println("Is String "+s5+" valid? "+isValidDP(s5)); // Output: false
    }
}