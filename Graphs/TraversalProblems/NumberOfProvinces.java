import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int V = adj.length;
        // Convert adjacency matrix to adjacency list
        List<Integer>[] adjLs = new ArrayList[V];

        for(int i = 0; i < V; i++){
            adjLs[i] = new ArrayList<>();
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(adj[i][j] == 1 && i != j){
                    adjLs[i].add(j);
                    adjLs[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int cnt = 0;

        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                cnt++;
                bfs(i, visited, adjLs);
            }
        }

        return cnt;
    }

    public void bfs(int node, boolean[] visited, List<Integer>[] adj){
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();

        q.offer(node);

        while(!q.isEmpty()){
            int i = q.poll();
            for(int neighbor: adj[i]){
                if(visited[neighbor] == false){
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] adj = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {1, 0, 0, 1}
        };
        
        NumberOfProvinces sol = new NumberOfProvinces();
        
        int ans = sol.numProvinces(adj);
        
        System.out.println("The number of provinces in the given graph is: " + ans);
    }
}
