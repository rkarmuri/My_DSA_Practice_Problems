import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectDAGCycle {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        int[] inDegree = new int[N];

        for(int i = 0; i < N; i++){
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            cnt++;

            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0)   q.offer(it);
            }
        }

        if(cnt == N)    return false;

        return true;
    }

    public boolean isCyclicDFS(int N, List<List<Integer>> adj) {
        boolean[] visited = new boolean[N];
        boolean[] pathVisited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(visited[i] == false){
                if(dfs(i, visited, pathVisited, adj)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj){
        visited[node] = true;
        pathVisited[node] = true;

        for(int it: adj.get(node)){
            if(pathVisited[it] == true){
                return true;
            } else if(visited[it] == false){
                if(dfs(it, visited, pathVisited, adj)){
                    return true;
                }
            }
        }
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(1).add(5);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(1);
        
        DetectDAGCycle sol = new DetectDAGCycle();
        
        boolean ans = sol.isCyclic(V, adj);
        boolean ans2 = sol.isCyclicDFS(V, adj);
        
        // Output
        if(ans)
            System.out.println("The given directed graph contains a cycle using Kahn's algorithm.");
        else 
            System.out.println("The given directed graph does not contain a cycle using Kahn's algorithm.");

        if(ans2)
            System.out.println("The given directed graph contains a cycle using DFS.");
        else 
            System.out.println("The given directed graph does not contain a cycle using DFS.");
    }
}
