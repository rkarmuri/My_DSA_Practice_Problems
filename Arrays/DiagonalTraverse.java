public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        // Time Complexity: O(m * n), Space Complexity: O(1) excluding output array
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int index = 0;

        // There are (rows + cols - 1) diagonals in total
        // All the indices (r, c) on the same diagonal satisfy r + c = d
        // If d is even, rows start with d or rows - 1, whatever is smaller
        // if d is odd, columns start with d or cols - 1, whatever is smaller

        for (int d = 0; d < rows + cols - 1; d++) {
            if (d % 2 == 0) {
                // Traverse upwards
                int r = Math.min(d, rows - 1); // Topmost row for this diagonal
                int c = d - r; // Corresponding column
                while (r >= 0 && c < cols) {
                    result[index++] = matrix[r--][c++];
                }
            } else {
                // Traverse downwards
                int c = Math.min(d, cols - 1); // Rightmost column for this diagonal
                int r = d - c; // Corresponding row
                while (c >= 0 && r < rows) {
                    result[index++] = matrix[r++][c--];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse dt = new DiagonalTraverse();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] result = dt.findDiagonalOrder(matrix);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
