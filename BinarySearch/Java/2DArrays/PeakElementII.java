public class PeakElementII {
    private static int maxElement(int[][] mat, int col){
        int maxValue = Integer.MIN_VALUE, maxIndex = -1;

        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>maxValue){
                maxValue = mat[i][col];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m - 1;

        while(low<=high){
            int mid = (low+high)/2;
            int row = maxElement(mat,mid);
            int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
            if((mid - 1) >= 0){
                left = mat[row][mid - 1];
            }
            if((mid + 1) < m){
                right = mat[row][mid + 1];
            }
            if((mat[row][mid] > left) && (mat[row][mid] > right)){
                return new int[]{row,mid};
            }
            else if(mat[row][mid] < left){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1,-1};
    }

    // Brute Force Approach
    public int[] findPeakGridBruteForce(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int current = mat[i][j];
                int up = (i-1)>=0 ? mat[i-1][j] : Integer.MIN_VALUE;
                int down = (i+1)<n ? mat[i+1][j] : Integer.MIN_VALUE;
                int left = (j-1)>=0 ? mat[i][j-1] : Integer.MIN_VALUE;
                int right = (j+1)<m ? mat[i][j+1] : Integer.MIN_VALUE;

                if(current > up && current > down && current > left && current > right){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        PeakElementII sol = new PeakElementII();
        int[][] mat = {
            {1, 4, 3, 6, 7},
            {8, 5, 9, 2, 1},
            {3, 6, 4, 5, 8},
            {7, 2, 1, 9, 4}
        };
        int[] result = sol.findPeakGrid(mat);
        System.out.println("Peak element found at: [" + result[0] + ", " + result[1] + "]");
        int[] bruteForceResult = sol.findPeakGridBruteForce(mat);   
        System.out.println("Peak element found (Brute Force) at: [" + bruteForceResult[0] + ", " + bruteForceResult[1] + "]");
    }
}
