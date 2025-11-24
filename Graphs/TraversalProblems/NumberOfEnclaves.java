import java.util.*;

public class NumberOfEnclaves {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Find the lands that are across the boundary
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1 ){
                    if(grid[i][j] == 1){
                        visited[i][j] = true;
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }

        // Perform BFS traversal and mark the lands connected to the lands across boundary
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && visited[newRow][newCol] == false){
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        int count = 0;
        // Traverse across the grid and find the lands that were not visited
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 1}, 
            {1, 0, 1, 0}, 
            {0, 0, 1, 0}, 
            {0, 0, 0, 0}
        };
        
        NumberOfEnclaves sol = new NumberOfEnclaves(); 
        
        int ans = sol.numberOfEnclaves(grid);
        
        System.out.println("The number of enclaves in given grid are: " + ans);
    }
}
