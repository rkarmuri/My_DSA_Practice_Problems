import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DijkstrasAlgorithm {
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a ,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, S});
        dist[S] = 0;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int d = node[0];
            int u = node[1];

            if (d > dist[u]) continue;

            for(List<Integer> adjNode : adj.get(u)){
                int v = adjNode.get(0);
                int wt = adjNode.get(1);

                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        return dist;
    }

    public  int[] dijkstraUsingSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        // Compare using node if distances are equal
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        set.add(new int[]{0, S});
        dist[S] = 0;

        while (!set.isEmpty()) {
            int[] node = set.pollFirst();
            int d = node[0];
            int u = node[1]; 

            if (d > dist[u]) continue;
            
            for (List<Integer> adjNode : adj.get(u)) {
                int v = adjNode.get(0);
                int wt = adjNode.get(1);

                if (dist[u] + wt < dist[v]) {
                    if(dist[v] != (int)1e9){
                        set.remove(new int[]{ dist[v], v });
                    }
                    dist[v] = wt + dist[u]; 
                    set.add(new int[]{dist[v], v}); 
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        
        int V = 2, S = 0;
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> node0 = new ArrayList<>();
        node0.add(new ArrayList<>(Arrays.asList(1, 9)));
        adj.add(node0);
        
        ArrayList<ArrayList<Integer>> node1 = new ArrayList<>();
        node1.add(new ArrayList<>(Arrays.asList(0, 9)));
        adj.add(node1);
        
        DijkstrasAlgorithm sol = new DijkstrasAlgorithm();
        
        int[] ans = sol.dijkstra(V, adj, S);
        int[] ans2 = sol.dijkstraUsingSet(V, adj, S);
        
        // Output
        System.out.print("The shortest distance of nodes from the source node is: ");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        System.out.print("The shortest distance of nodes from the source node using Sets is: ");
        for (int i = 0; i < V; i++) {
            System.out.print(ans2[i] + " ");
        }
        System.out.println();
    }
}
