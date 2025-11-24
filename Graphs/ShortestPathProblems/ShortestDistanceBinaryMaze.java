import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceBinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;

        int[][] dist = new int[n][m];

        for(int[] row: dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[source[0]][source[1]] = 0;
        q.offer(new int[]{0, source[0], source[1]});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int d = curr[0];
            int row = curr[1];
            int col = curr[2];

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && d + 1 < dist[newRow][newCol]){
                    dist[newRow][newCol] = d + 1;
                    if(newRow == destination[0] && newCol == destination[1]){
                        return d + 1;
                    }

                    q.offer(new int[]{d + 1, newRow, newCol});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] source = {0, 0};
        int[] destination = {2, 3};
        
        int[][] grid = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}
        };
        
        ShortestDistanceBinaryMaze sol = new ShortestDistanceBinaryMaze();
        
        int ans = sol.shortestPath(grid, source, destination);
        
        System.out.println("The shortest distance from the source to destination is: " + ans);
    }
}
