import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathDAG {
    class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Compute indegree
        int[] inDegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (Pair p : adj.get(i)) {
                inDegree[p.first]++;
            }
        }

        // Topo sort using Kahn's algorithm
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int[] topo = new int[N];
        int index = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;

            for (Pair p : adj.get(node)) {
                int v = p.first;
                inDegree[v]--;
                if (inDegree[v] == 0) q.offer(v);
            }
        }

        // Initialize distances
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0; 

        // Relax edges in topological order
        for (int i = 0; i < index; i++) {
            int node = topo[i];

            if (dist[node] != (int)1e9) {
                for (Pair p : adj.get(node)) {
                    int v = p.first;
                    int wt = p.second;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
            else if(dist[node] == (int)1e9){
                dist[node] = -1;
            }
        }

        return dist;
    }


    public static void main(String[] args) {

        int N = 6, M = 7;
        int[][] edges = {
            {0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}
        };

        ShortestPathDAG sol = new ShortestPathDAG();

        int[] ans = sol.shortestPath(N, M, edges);

        System.out.println("The shortest distance of every node from source node is:");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
