import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUG {
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        dist[0] = 0;

        q.add(0); 
        
        while (!q.isEmpty()) {
            int node = q.poll(); 
            
            for (int adjNode : adj.get(node)) {
                if (dist[node] + 1 < dist[adjNode]) {
                    dist[adjNode] = 1 + dist[node]; 
                    q.add(adjNode); 
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) 
                dist[i] = -1;
        }

        return dist;
    }
    
    public static void main(String[] args) {
        
        int N = 9, M = 10;
        int[][] edges = {
            {0, 1}, {0, 3}, {3, 4}, 
            {4, 5}, {5, 6}, {1, 2}, 
            {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };
        
        ShortestPathUG sol = new ShortestPathUG();
        
        int[] ans = sol.shortestPath(edges, N, M);
        
        System.out.println("The shortest distance of every node from source node is:");
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
