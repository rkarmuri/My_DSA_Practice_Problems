import java.util.Arrays;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.HashSet;

public class WordLadderI {
    class Pair{
        String first;
        int second;
        Pair(String s, int i){
            this.first = s;
            this.second = i;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(targetWord)){
            return 0;
        }

        q.offer(new Pair(startWord, 1));
        
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;

            q.poll();

            if(word.equals(targetWord)){
                return steps;
            }

            char[] charArr = word.toCharArray();
            for(int i = 0; i < charArr.length; i++){
                char original = charArr[i];

                for(char ch = 'a'; ch <= 'z'; ch++){
                    charArr[i] = ch;
                    String newWord = new String(charArr);

                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps + 1));
                    }
                }

                charArr[i] = original;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        List<String> wordList = Arrays.asList("des", "der", "dfr", "dgt", "dfs");

        WordLadderI sol = new WordLadderI();

        int ans = sol.wordLadderLength(startWord, targetWord, wordList);

        System.out.println("Word ladder length is: " + ans);
    }
}
