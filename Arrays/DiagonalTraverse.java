public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int index = 0;

        for (int d = 0; d < rows + cols - 1; d++) {
            if (d % 2 == 0) {
                // Traverse upwards
                int r = Math.min(d, rows - 1);
                int c = d - r;
                while (r >= 0 && c < cols) {
                    result[index++] = matrix[r--][c++];
                }
            } else {
                // Traverse downwards
                int c = Math.min(d, cols - 1);
                int r = d - c;
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
