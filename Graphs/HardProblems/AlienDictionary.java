import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    private List<Integer> topoSort(int V, List<Integer>[] adj) {
        int[] inDegree = new int[V];
        
        for (int i = 0; i < V; i++) {    
            for (int it : adj[i]) {
                inDegree[it]++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        
        return ans;
    }
    public String findOrder(String [] dict, int N, int K) {
        List<Integer>[] adj = new ArrayList[K];

        for (int i = 0; i < K; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++){
            String s1 = dict[i], s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());

            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj[s1.charAt(ptr) - 'a'].add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < K; i++){
            ans.append((char) ('a' + topo.get(i)));
            ans.append(' ');
        }

        return ans.toString();
    }
    
    public static void main(String[] args) {
        
        int N = 5, K = 4;
        String[] dict = {
            "baa", "abcd", "abca", "cab", "cad"
        };
        
        AlienDictionary sol = new AlienDictionary();
        
        String ans = sol.findOrder(dict, N, K);
        
        // Output
        System.out.println("The order to characters as per alien dictionary is: " + ans);
    }
}
