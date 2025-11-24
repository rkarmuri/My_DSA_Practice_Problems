public class MinimumWindowSubstring {
    // Time Complexity: O(N), Space Complexity: O(1)
    public String minWindow(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1, r = 0, l = 0;
        
        int[] hash = new int[256];

        for(char c: t.toCharArray()){
          hash[c]++;
        }

        int count = 0;
        while(r < slen){
          if(hash[s.charAt(r)] > 0){
            count++;
          }
          hash[s.charAt(r)]--;

          while(count == tlen){
            if(r - l + 1 < minLen){
              minLen = r - l + 1;
              sIndex = l;
            }

            hash[s.charAt(l)]++;
            if(hash[s.charAt(l)] > 0){
              count--;
            }
            l++;
          }

          r++;
        }
        return (sIndex == -1)? "":s.substring(sIndex, sIndex+minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + solution.minWindow(s, t)); // Output: "BANC"
    }
}
