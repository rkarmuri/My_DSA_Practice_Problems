import java.util.*;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
       int n = grid.length, m = grid[0].length;

       boolean[][] visited = new boolean[n][m];
       int cnt = 0;

       for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(visited[i][j] == false && grid[i][j] == '1'){
                cnt++;
                bfs(i, j, visited, grid);
            }
        }
       }

       return cnt;
    }

    public void bfs(int i, int j, boolean[][] visited, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        int n = grid.length, m = grid[0].length;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];

            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                    int newRow = row + delRow;
                    int newCol = col + delCol;

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && (grid[newRow][newCol] == '1') && (visited[newRow][newCol] == false)){
                        visited[newRow][newCol] = true;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '0', '1'},
            {'1', '0', '0', '0', '0'},
            {'1', '1', '1', '0', '1'},
            {'0', '0', '0', '1', '1'}
        };
        
        NumberOfIslands sol = new NumberOfIslands();
        
        int ans = sol.numIslands(grid);
        
        System.out.println("The total islands in given grids are: " + ans);
    }
}
