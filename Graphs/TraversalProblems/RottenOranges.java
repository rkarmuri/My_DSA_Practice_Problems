import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // Find all the rotten and fresh oranges
        int rottenCount = 0, freshCount = 0, time = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2 && !visited[i][j]){
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                } else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1], t = cell[2];
            time = Math.max(time, t);

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 2;
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol, t + 1});   
                    rottenCount++;
                }
            }
        }

        if (rottenCount < freshCount)   return -1;

        return time;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1}, 
            {1, 1, 0}, 
            {0, 1, 1}
        };
        
        RottenOranges sol = new RottenOranges(); 
        
        int ans = sol.orangesRotting(grid);
        
        System.out.println("The minimum number of minutes required for all oranges to rotten are: " + ans);
    }
}
