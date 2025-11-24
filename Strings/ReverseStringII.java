package Strings;

import java.util.Vector;

public class ReverseStringII {
    private void reverseString(Vector<Character> s) {
        int left = 0, right = s.size()-1;

        while(left<right){
            char ch = s.get(left);
            s.set(left,s.get(right));
            s.set(right,ch);
            left++;
            right--;
        }
    }

    // Test cases
    private static void testReverseString() {
        ReverseStringII rs = new ReverseStringII();

        Vector<Character> s1 = new Vector<>();
        String str1 = "hello";
        System.out.println("Original string: " + str1);
        for (char c : str1.toCharArray()) {
            s1.add(c);
        }
        rs.reverseString(s1);
        System.out.println("Reversed string: " + s1);

        Vector<Character> s2 = new Vector<>();
        String str2 = "world";
        System.out.println("Original string: " + str2);
        for (char c : str2.toCharArray()) {
            s2.add(c);
        }
        rs.reverseString(s2);
        System.out.println("Reversed string: " + s2);
    }

    public static void main(String[] args) {
        testReverseString();
    }
}
