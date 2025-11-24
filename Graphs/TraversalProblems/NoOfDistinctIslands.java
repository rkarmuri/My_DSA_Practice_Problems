import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class NoOfDistinctIslands {
    public int countDistinctIslands(int[][] grid) {
      int n = grid.length, m = grid[0].length;
      boolean[][] visited = new boolean[n][m];
      HashSet<String> st = new HashSet<>();
      
      for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 1 && !visited[i][j]){
                StringBuilder sb = new StringBuilder();
                bfs(grid, i, j, visited, sb);
                st.add(sb.toString());
            }
        }
      }

      return st.size();
    }

    public void bfs(int[][] grid, int i, int j, boolean
    [][] visited, StringBuilder sb){
        int n = grid.length, m = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int baseRow = i, baseCol = j;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];

            sb.append((row - baseRow) + "," + (col - baseCol) + ";");

            for(int k = 0; k < 4; k++){
                int newRow = row + delRow[k];
                int newCol = col + delCol[k];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Input grid
        int[][] grid = {
            {1,1,0,0},
            {1,0,0,0},
            {0,0,1,1},
            {0,0,1,1}
        };

        NoOfDistinctIslands obj = new NoOfDistinctIslands();

        int ans = obj.countDistinctIslands(grid);

        // Print result
        System.out.println("The number of distinct islands: " + ans);
    }
}
