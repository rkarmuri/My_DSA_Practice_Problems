import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];

        for(int i = 0; i < V; i++)  color[i] = -1;

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!bfs(i, V, adj, color)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int start, int V, List<List<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.poll();

            for(int it:adj.get(node)){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.offer(it);
                } else if(color[it] == color[node]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartiteDFS(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private boolean dfs(int node, int col, int[] color, List<List<Integer>> adj) {                   
        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - col, color, adj)) 
                    return false; 
            }
            
            else if (color[it] == col) {
                return false; 
            }
        }
        
        return true; 
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 3));
        adj.get(1).addAll(Arrays.asList(0, 2));
        adj.get(2).addAll(Arrays.asList(1, 3));
        adj.get(3).addAll(Arrays.asList(0, 2));

        BipartiteGraph sol = new BipartiteGraph(); 

        boolean ans = sol.isBipartite(V, adj);
        boolean ans2 = sol.isBipartiteDFS(V, adj);
        
        // Output
        if (ans) 
            System.out.println("The given graph is a bipartite graph using BFS.");
        else 
            System.out.println("The given graph is not a bipartite graph.");

        if (ans2) 
            System.out.println("The given graph is a bipartite graph using DFS.");
        else 
            System.out.println("The given graph is not a bipartite graph.");
    }
}
