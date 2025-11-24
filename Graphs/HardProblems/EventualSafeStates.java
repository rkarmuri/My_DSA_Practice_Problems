import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {
    public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, boolean[] check, int[][] adj){
        visited[node] = true;
        pathVisited[node] = true;

        for(int it: adj[node]){
            if(!visited[it]){
                if(dfs(it, visited, pathVisited, check, adj)){
                    return true;
                }
            } 
            else if(pathVisited[it]){
                return true;
            }
            
        }
        pathVisited[node] = false;
        check[node] = true;
        return false;
    }
    
    public int[] eventualSafeNodes(int V, int[][] adj) {
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, visited, pathVisited, check, adj);
            }
        }

        for(int i = 0; i < V; i++){
            if(check[i]){
                temp.add(i);
            }
        }

        int N = temp.size();
        int[] ans = new int[N];
        for(int i = 0; i < N; i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }

    public int[] eventualSafeNodesBFS(int V, int[][] adj) {
        // Step 1: Reverse the graph
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int it : adj[i]) {
                adjRev.get(it).add(i);
            }
        }

        // Step 2: Build indegree array
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adjRev.get(i)) {
                indegree[it]++;
            }
        }

        // Step 3: Kahn’s BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> safeNodes = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);

            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        // Step 4: Sort and return result
        Collections.sort(safeNodes);

        int[] ans = new int[safeNodes.size()];
        for (int i = 0; i < safeNodes.size(); i++) {
            ans[i] = safeNodes.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 7;
        int[][] adj = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };
        
        EventualSafeStates sol = new EventualSafeStates();
        
        int[] ans = sol.eventualSafeNodes(V, adj);
        int[] ans2 = sol.eventualSafeNodesBFS(V, adj);
        
        // Output
        System.out.println("The eventually safe nodes in the graph are:");
        for (int node : ans) {
            System.out.print(node + " ");
        }

        System.out.println();
        System.out.println("The eventually safe nodes using BFS in the graph are:");
        for (int node : ans2) {
            System.out.print(node + " ");
        }
    }
}
