public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col]==target)    return true;
            else if(matrix[row][col] > target)  col--;
            else    row++;
        }

        return false;
    }

    // Brute Force Approach
    private boolean searchMatrixBruteForce(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target)    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixII sol = new Search2DMatrixII();
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 5;
        boolean result = sol.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found in matrix: " + result);

        int target2 = 20;
        boolean result2 = sol.searchMatrixBruteForce(matrix, target2);
        System.out.println("Target " + target2 + " found in matrix: " + result2);
    }
}
