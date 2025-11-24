import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightKSteps {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
      if(src == dst)    return 0;

      List<List<int[]>> adj = new ArrayList<>();

      for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
      }

      for(int[] flight: flights){
        adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
      }

      Queue<int[]> q = new LinkedList<>();

      int[] dist = new int[n];
      Arrays.fill(dist, Integer.MAX_VALUE);
      
      q.offer(new int[]{0, src, 0});

      while(!q.isEmpty()){
        int[] curr = q.poll();
        int u = curr[1];
        int stop = curr[0];
        int cost = curr[2];

        for(int[] adjNode : adj.get(u)){
            int v = adjNode[0];
            int wt = adjNode[1];

            if(cost + wt < dist[v] && stop <= K){
                dist[v] = cost + wt;
                q.offer(new int[]{stop + 1, v, dist[v]});
            }
        }
      }

      if(dist[dst] == Integer.MAX_VALUE){
        return -1;
      }

      return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        
        int src = 0, dst = 3, k = 1;
        
        CheapestFlightKSteps sol = new CheapestFlightKSteps(); 
        
        int ans = sol.CheapestFlight(n, flights, src, dst, k);
        
        // Output
        System.out.println("The cheapest flight from source to destination within K stops is: " + ans);
    }
}
