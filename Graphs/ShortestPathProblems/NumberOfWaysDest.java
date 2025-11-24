import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysDest {
    public int countPaths(int n, List<List<Integer>> roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> road : roads){
            adj.get(road.get(0)).add(new int[]{road.get(1), road.get(2)});
            adj.get(road.get(1)).add(new int[]{road.get(0), road.get(2)});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));

        long[] ways = new long[n];
        long[] dist = new long[n];

        long mod = (long)1e9 + 7;

        Arrays.fill(ways, 0);
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long time = curr[0];
            int u = (int)curr[1];

            if (time > dist[u]) continue;

            for(int[] adjNode : adj.get(u)){
                int v = adjNode[0];
                int wt = adjNode[1];

                if(time + wt < dist[v]){
                    dist[v] = time + wt;
                    ways[v] = ways[u];
                    pq.offer(new long[]{dist[v], v});
                }
                else if(time + wt == dist[v]){
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }

        return (int)(ways[n - 1] % mod);
    }

    public static void main(String[] args) {
        int n = 7, m = 20;
        List<List<Integer>> roads = Arrays.asList(
            Arrays.asList(0, 6, 7), 
            Arrays.asList(0, 1, 2), 
            Arrays.asList(1, 2, 3),
            Arrays.asList(1, 3, 3), 
            Arrays.asList(6, 3, 3), 
            Arrays.asList(3, 5, 1),
            Arrays.asList(6, 5, 1), 
            Arrays.asList(2, 5, 1), 
            Arrays.asList(0, 4, 5),
            Arrays.asList(4, 6, 2)
        );
        
        NumberOfWaysDest sol = new NumberOfWaysDest();
        
        int ans = sol.countPaths(n, roads);
        
        // Output
        System.out.println("The number of ways to arrive at destinations in shortest possible time is: " + ans);
    }
}
