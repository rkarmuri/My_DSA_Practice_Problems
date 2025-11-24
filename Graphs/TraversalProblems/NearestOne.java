import java.util.Queue;
import java.util.LinkedList;

public class NearestOne {
    public int[][] nearest(int[][] grid) {
       int n = grid.length, m = grid[0].length;
       Queue<int[]> q = new LinkedList<>();
       boolean[][] visited = new boolean[n][m];
       int[][] distance = new int[n][m];

       // Find all the 1s in the grid
       for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 1 && !visited[i][j]){
                visited[i][j] = true;
                q.offer(new int[]{i, j, 0});
            }
        }
       }

       int[] delRow = {-1, 0, 1, 0};
       int[] delCol = {0, 1, 0, -1};

       while(!q.isEmpty()){
        int[] cell = q.poll();
        int row = cell[0], col = cell[1], steps = cell[2];

        distance[row][col] = steps;

        for(int i = 0; i < 4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){
                visited[newRow][newCol] = true;
                q.offer(new int[]{newRow, newCol, steps + 1});
            }
        }
       }

       return distance;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 1, 0}, 
            {1, 1, 0, 0}, 
            {0, 0, 1, 1}
        };
        
        NearestOne sol = new NearestOne();
        
        int[][] ans = sol.nearest(grid);
        
        int n = ans.length;
        int m = ans[0].length;
        
        // Output
        System.out.println("The distance of the nearest 1 in the grid for each cell is: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
