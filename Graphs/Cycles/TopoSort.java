import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopoSort {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] ans = new int[V];

        Stack<Integer> st = new Stack<>();

        int[] visited = new int[V];

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i, visited, adj, st);
            }
        }

        for(int i = 0; i < V; i++){
            ans[i] = st.pop();
        }

        return ans;
    }

    public void dfs(int node, int[] visited, List<List<Integer>> adj, Stack<Integer> st){
        visited[node] = 1;

        for(int it: adj.get(node)){
            if(visited[it] == 0){
                dfs(it, visited, adj, st);
            }
        }

        st.push(node);
    }
    
    public int[] kahnsAlgorithm(int V, List<List<Integer>> adj) {
        int[] ans = new int[V];

        int[] inDegree = new int[V];

        for(int i = 0; i < V; i++){
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int index = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            ans[index++] = node;

            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0)   q.offer(it);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 6;

        // Initializing adjacency list with List<List<Integer>>
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding directed edges
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        // Creating an instance of Solution class
        TopoSort sol = new TopoSort();

        // Calling topoSort function
        int[] ans = sol.topoSort(V, adj);
        int[] ans2 = sol.kahnsAlgorithm(V, adj);

        // Output the topological order
        System.out.println("The topological sorting of the given graph using DFS is:");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        System.out.println("The topological sorting of the given graph using Kahn's algorithm is:");
        for (int i = 0; i < V; i++) {
            System.out.print(ans2[i] + " ");
        }
    }
}
