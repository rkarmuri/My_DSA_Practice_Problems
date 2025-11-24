import java.util.Arrays;

public class LongestSubstring {
    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0, l = 0, r = 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while(r < n){
            if(hash[s.charAt(r)] >= l){
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            hash[s.charAt(r)] = r;
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + lengthOfLongestSubstring(s)); // Output: 3
    }
}
