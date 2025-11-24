import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class CountComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int E = edges.size();

        ArrayList<Integer>[] adj = new ArrayList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            adj[edges.get(i).get(0)].add(edges.get(i).get(1));
            adj[edges.get(i).get(1)].add(edges.get(i).get(0));
        }

        boolean[] visited = new boolean[V];
        int cnt = 0;
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                cnt++;
                bfs(i, visited, adj);
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
        int V = 4;
        List<List<Integer>> edges = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2)
        );

        CountComponents sol = new CountComponents();

        int ans = sol.findNumberOfComponent(V, edges);

        System.out.println("The number of components in the given graph is: " + ans);
    }
}
