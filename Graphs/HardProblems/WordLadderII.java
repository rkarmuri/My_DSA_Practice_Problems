import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        List<List<String>> ans = new ArrayList<>();

        if(!set.contains(endWord)){
            return ans;
        }

        q.offer(new ArrayList<>(Arrays.asList(beginWord)));

        Set<String> toErase = new HashSet<>();

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                List<String> seq = q.poll();

                String word = seq.get(seq.size() - 1);
                char[] charArr = word.toCharArray();

                for(int pos = 0; pos < charArr.length; pos++){
                    char original = charArr[pos];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if (ch == original) continue;
                        charArr[pos] = ch;
                        String newWord = new String(charArr);

                        if(set.contains(newWord)){
                            List<String> newSeq = new ArrayList<>(seq);
                            newSeq.add(newWord);

                            if (newWord.equals(endWord)) {
                                ans.add(newSeq);
                            } else {
                                q.offer(newSeq);
                            }
                            toErase.add(newWord);
                        }
                    }

                    charArr[pos] = original;
                }
            }
            
            if(!ans.isEmpty())  break;

            for(String it: toErase){
                set.remove(it);
            }
            toErase.clear();
        }

        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "der", endWord = "dfs";
        List<String> wordList = new ArrayList<>(Arrays.asList("des", "der", "dfr", "dgt", "dfs"));
        
        WordLadderII sol = new WordLadderII();
        
        List<List<String>> ans = sol.findSequences(beginWord, endWord, wordList);
        
        System.out.println("The different sequences are:");
        for (List<String> sequence : ans) {
            for (String word : sequence) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
