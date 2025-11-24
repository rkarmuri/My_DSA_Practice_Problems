public class NoOfStringAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int n = s.length(), count = 0;

        int[] lastSeen = {-1, -1, -1};

        for(int i = 0; i < n; i++){
          lastSeen[s.charAt(i) - 'a'] = i;

          if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!= -1){
            count += 1 + Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]);
          }
        }

        return count;
    }

    public static void main(String[] args) {
        NoOfStringAllThreeCharacters solution = new NoOfStringAllThreeCharacters();
        String s = "abcabc";
        System.out.println("Number of substrings containing all three characters: " + solution.numberOfSubstrings(s)); // Output: 10
    }
}
