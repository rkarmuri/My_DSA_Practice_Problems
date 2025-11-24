package Arrays;

public class Rotate90Degrees {
    private static void transposeMatrix(int[][] matrix){
        int n = matrix.length;

        for(int i=0;i < n;i++){
            for(int j=i+1;j < n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void rotateMatrix(int[][] matrix){
        int n = matrix.length;
        transposeMatrix(matrix);

        // Reverse each row
        for(int i=0;i < n;i++){
            int left = 0, right = n - 1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int n = matrix.length;

        rotateMatrix(matrix);
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
