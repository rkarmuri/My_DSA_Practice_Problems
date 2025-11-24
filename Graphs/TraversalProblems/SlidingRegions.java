import java.util.Queue;
import java.util.LinkedList;

public class SlidingRegions {
    public char[][] fill(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();

        // Traverse across the first and last rows
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O' && !visited[0][j]){
                q.offer(new int[]{0, j});
                visited[0][j] = true;
            }
            if(board[n - 1][j] == 'O' && !visited[n - 1][j]){
                q.offer(new int[]{n - 1, j});
                visited[n - 1][j] = true;
            }
        }

        // Traverse across the first and last columns
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O' && !visited[i][0]){
                q.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
            if(board[i][m - 1] == 'O' && !visited[i][m - 1]){
                q.offer(new int[]{i, m - 1});
                visited[i][m - 1] = true;
            }
        }

        // Traverse across the boundaries to find any connected Os
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 'O' && !visited[newRow][newCol]){
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        // Travese across the matrix to find any Os that are not visited and mark them X
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
        char[][] mat = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        
        SlidingRegions sol = new SlidingRegions();
        
        char[][] ans = sol.fill(mat);
        
        int n = ans.length;
        int m = ans[0].length;
        
        // Output
        System.out.println("The updated matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
