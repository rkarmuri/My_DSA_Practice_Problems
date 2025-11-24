package Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(str);

        String first = str[0], last = str[str.length - 1];

        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                break;
            }
            ans.append(first.charAt(i));
        }

        return ans.toString();

    }

    // Test cases
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix of test1: " + lcp.longestCommonPrefix(test1)); // Output: "fl"
        System.out.println("Longest common prefix of test2: " + lcp.longestCommonPrefix(test2)); // Output: ""
    }
}
