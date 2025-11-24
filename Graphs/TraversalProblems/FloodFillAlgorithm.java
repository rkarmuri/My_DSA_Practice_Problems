import java.util.Arrays;

public class FloodFillAlgorithm {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];

        int[][] ans = new int[image.length][image[0].length];

        for(int i = 0; i < image.length; i++){
            ans[i] = Arrays.copyOf(image[i], image[i].length);
        }

        dfs(sr, sc, iniColor, newColor, ans, image);

        return ans;
    }

    public void dfs(int row, int col, int iniColor, int newColor, int[][] ans, int[][] image){
        ans[row][col] = newColor;

        int n = image.length, m = image[0].length;

        for(int i = 0; i < 4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == iniColor && ans[newRow][newCol] != newColor){
                dfs(newRow, newCol, iniColor, newColor, ans, image);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1;
        int newColor = 2;
        
        // Creating an instance of Solution class
        FloodFillAlgorithm sol = new FloodFillAlgorithm();
        
        // Function call to find the number of islands in given grid
        int[][] ans = sol.floodFill(image, sr, sc, newColor);
        
        System.out.println("Image after performing flood fill algorithm:\n");
        
        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
