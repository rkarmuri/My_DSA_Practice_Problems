package Strings;

public class IsomorphicString {
    private boolean isomorphicString(String s, String t) {
        int[] h1 = new int[256], h2 = new int[256];

        int n = s.length();

        for(int i=0;i<n;i++){
            // Check if the last position of the char is mapped correctly
            if(h1[s.charAt(i)]!=h2[t.charAt(i)]){
                return false;
            }

            h1[s.charAt(i)] = i+1;
            h2[t.charAt(i)] = i+1;
        }

        return true;
    }

    // Test cases
    public static void main(String[] args) {
        IsomorphicString iso = new IsomorphicString();
        System.out.println("Are 'egg' and 'add' isomorphic? " + iso.isomorphicString("egg", "add")); // Output: true
        System.out.println("Are 'foo' and 'bar' isomorphic? " + iso.isomorphicString("foo", "bar")); // Output: false
        System.out.println("Are 'paper' and 'title' isomorphic? " + iso.isomorphicString("paper", "title")); // Output: true
    }
}
