import java.util.HashMap;
public class LongestRepeatingCharacter {
    // Time Complexity: O(N), Space Complexity: O(1)
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxLen = 0, l = 0, r = 0, maxFreq = 0;
        int[] hash = new int[26];

        while(r < n){
          hash[s.charAt(r) - 'A']++;
          maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
          int conversions = (r - l + 1) - maxFreq;

          if(conversions > k){
            hash[s.charAt(l) - 'A']--;
            l++;
          }

          maxLen = Math.max(maxLen, r - l + 1);
          r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacter solution = new LongestRepeatingCharacter();
        String s = "AABABBA";
        int k = 1;
        System.out.println("Longest Repeating Character Replacement: " + solution.characterReplacement(s, k)); // Output: 4
    }
}
