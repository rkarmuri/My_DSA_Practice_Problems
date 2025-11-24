public class MatrixMedian {
    private static int upperBound(int[] arr, int x, int m){
        int low = 0, high = m - 1;
        int ans = m;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]<=x){
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    private int countSmallEqual(int[][] matrix, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += upperBound(matrix[i], x, m);
        }
        return cnt;
    }

    public int findMedian(int[][] matrix) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // Initialize low and high
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int req = (n * m) / 2;
        
        // Perform binary search to find the median
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallEqual = countSmallEqual(matrix, n, m, mid);

            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    // Brute Force Approach
    private int findMedianBruteForce(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int size = n * m;
        int[] arr = new int[size];
        int index = 0;

        // Flatten the matrix into a single array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[index++] = matrix[i][j];
            }
        }

        // Sort the array
        java.util.Arrays.sort(arr);

        // Return the median
        return arr[size / 2];
    }

    public static void main(String[] args) {
        MatrixMedian sol = new MatrixMedian();
        int[][] mat = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        int result = sol.findMedian(mat);
        System.out.println("Median of the matrix: " + result);
        int bruteForceResult = sol.findMedianBruteForce(mat);
        System.out.println("Median of the matrix (Brute Force): " + bruteForceResult);
    }
}
