import java.util.HashMap;
public class LongestSubstringAtmostK {
    // Time Complexity: O(N), Space Complexity: O(K)
    public int longestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int r = 0, l = 0, maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if (map.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringAtmostK solution = new LongestSubstringAtmostK();
        String s = "eceba";
        int k = 2;
        System.out.println("Longest Substring with at most " + k + " distinct characters: " + solution.longestSubstringKDistinct(s, k)); // Output: 3
    }
}
