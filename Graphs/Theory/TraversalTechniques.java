import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TraversalTechniques {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        dfs(0, visited, adj, ans);

        return ans;
    }

    public List<Integer> dfs(int node, boolean[] visited,List<List<Integer>> adj, List<Integer> ans){
        visited[node] = true;
        ans.add(node);

        for(int neighbor:adj.get(node)){
            if(visited[neighbor] == false){
                dfs(neighbor, visited, adj, ans);
            }
        }

        return ans;
    }
    
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int it:adj.get(node)){
                if(visited[it] == false){
                    visited[it] = true;
                    q.offer(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).addAll(Arrays.asList(2, 3, 1));
        adj.get(1).add(0);
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).add(0);
        adj.get(4).add(2);

        TraversalTechniques sol = new TraversalTechniques();

        List<Integer> bfs = sol.bfsOfGraph(V, adj);
        List<Integer> dfs = sol.dfsOfGraph(V, adj);

        System.out.println("The BFS traversal of the given graph is: " + bfs);
        System.out.println("The DFS traversal of the given graph is: " + dfs);
    }
}
