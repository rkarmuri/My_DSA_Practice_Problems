package Strings;

public class RotateString {
    private static boolean rotateStringBF(String s, String goal) {
        if (s.length()!=goal.length()) {
            return false;
        }

        String left = ""; // left part of the string

        // Traverse across the string and combine the rotated parts
        for(int i=0;i<s.length();i++){
            String right = s.substring(i); // right part of the string
            if((right+left).equals(goal)){
                return true;
            }
            left += s.charAt(i);
        }
        return false;
    }

    private static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String combined = s + s;
        return combined.contains(goal);
    }

    // Test cases
    private static void testRotateString() {
        System.out.println("Using Brute force: " + rotateStringBF("ghiklm", "klmghi"));
        System.out.println("Using Brute force: " + rotateStringBF("nuopki", "oinupk"));
        System.out.println("Using Brute force: " + rotateStringBF("abcdef", "dabcef"));
        System.out.println("Using Optimized: " + rotateString("abcdef", "defabc"));
        System.out.println("Using Optimized: " + rotateString("ghiklm", "klhilm"));
        System.out.println("Using Optimized: " + rotateString("nuopki", "opiknu"));
    }

    public static void main(String[] args) {
        System.out.println("Testing rotateString:");
        testRotateString();
    }
}
