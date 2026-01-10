public class FindMatchingStrings {
    public static String checkMatchingStrings(String S1, String S2, String R){
        // Time Complexity: O(n), Space Complexity: O(1)
        String concatenated = S1 + S2;
        if(concatenated.equals(R)){
            return "YES";   
        }

        return "NO";
    }
    
    // Using Hashing Approach
    public static String checkMatchingStringsHashing(String S1, String S2, String R){
        // Time Complexity: O(n), Space Complexity: O(256)
        if(S1.length() + S2.length() != R.length()){
            return "NO";
        }

        int[] hash = new int[256]; // Assuming ASCII character set

        for(char c : S1.toCharArray()){
            hash[c]++;
        }
        for(char c : S2.toCharArray()){
            hash[c]++;
        }
        for(char c : R.toCharArray()){
            hash[c]--;
        }
        for(int count : hash){
            if(count != 0){
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        String S1 = "Hello";
        String S2 = "World";
        String R1 = "HelloWorld";
        String R2 = "WorldHello";
        System.out.println(checkMatchingStrings(S1, S2, R1)); // Output: YES
        System.out.println(checkMatchingStringsHashing(S1, S2, R2)); // Output: YES
        String R3 = "HelloThere";
        System.out.println(checkMatchingStrings(S1, S2, R3)); // Output: NO
    }
}
