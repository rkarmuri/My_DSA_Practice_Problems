package Strings;

public class PalindromeCheck {
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Test cases
    private static void testIsPalindrome() {
        System.out.println("Is the string 'racecar' a palindrome? " + isPalindrome("racecar")); // Output: true
        System.out.println("Is the string 'hello' a palindrome? " + isPalindrome("hello"));   // Output: false
        System.out.println("Is the string 'anagram' a palindrome? " + isPalindrome("anagram"));   // Output: false
    }

    public static void main(String[] args) {
        testIsPalindrome();
    }
}
