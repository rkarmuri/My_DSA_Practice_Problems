import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)) return true;
            }
        }

        return false;
    }

    public boolean bfs(int i, List<Integer>[] adj, boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, -1});
        visited[i] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0], parent = current[1];

            for(int it: adj[node]){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(new int[]{it, node});
                }
                else if(it != parent)   return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, List<Integer> adj[], boolean[] visited, int prev) {
        visited[i] = true;
        
        for (int node : adj[i]) {
            if (!visited[node]) {
                if (dfs(node, adj, visited, i)) {
                    return true;
                }
            }
            else if (node != prev) {
                return true;
            }
        }
        
        return false;
    }

    public boolean isCycleDFS(int V, List<Integer> adj[]) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));
        
        DetectCycle sol = new DetectCycle();
        
        boolean ans = sol.isCycle(V, adj);
        boolean ans2 = sol.isCycleDFS(V, adj);
        
        // Output
        if (ans) 
            System.out.println("The given graph contains a cycle using BFS.");
        else 
            System.out.println("The given graph does not contain a cycle.");

        if (ans2) 
            System.out.println("The given graph contains a cycle using DFS.");
        else 
            System.out.println("The given graph does not contain a cycle.");
    }
}
