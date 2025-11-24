public class Search2DMatrix {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = n * m - 1;

        while(low<=high){
            int mid = (low+high)/2;
            int row = mid / m;
            int col = mid % m;

            if(mat[row][col]==target){
                return true;
            }
            else if(mat[row][col]<target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }

    // Brute Force Approach
    public boolean searchMatrixBruteForce(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix sol = new Search2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = sol.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found in matrix: " + result);

        boolean bruteForceResult = sol.searchMatrixBruteForce(matrix, target);
        System.out.println("Target " + target + " found in matrix (Brute Force): " + bruteForceResult);
    }
}
