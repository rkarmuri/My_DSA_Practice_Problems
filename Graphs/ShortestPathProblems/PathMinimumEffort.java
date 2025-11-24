import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathMinimumEffort {
    public int MinimumEffort(List<List<Integer>> heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int n = heights.size(), m = heights.get(0).size();

        int[][] dist = new int[n][m];
        dist[0][0] = 0;

        for(int[] row: dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        pq.offer(new int[]{0, 0, 0});

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int diff = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == n - 1 && col == m - 1){
                return diff;
            }

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m){
                    int currDiff = Math.abs(heights.get(row).get(col) - heights.get(newRow).get(newCol));
                    int maxDiff = Math.max(currDiff, diff);

                    if(maxDiff < dist[newRow][newCol]){
                        dist[newRow][newCol] = maxDiff;
                        pq.offer(new int[]{maxDiff, newRow, newCol});    
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        List<List<Integer>> heights = Arrays.asList(
                Arrays.asList(1, 2, 2),
                Arrays.asList(3, 8, 2),
                Arrays.asList(5, 3, 5)
        );

        PathMinimumEffort sol = new PathMinimumEffort();

        int ans = sol.MinimumEffort(heights);

        // Output
        System.out.println("The minimum efforts required to go from cell (0,0) to cell (row-1, col-1) is: " + ans);
    }
}
