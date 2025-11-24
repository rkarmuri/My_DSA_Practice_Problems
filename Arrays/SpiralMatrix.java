package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        List<Integer> ans = new ArrayList<>();

        while(top <= bottom && left <= right){
            // Traverse from left to right
            for(int i = left;i <= right;i++){
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for(int i = top;i <= bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            
            if(top <= bottom){
                // Traverse from right to left
                for(int i = right;i >= left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                // Traverse from bottom to top
                for(int i = bottom;i >= top;i--){
                    ans.add(matrix[i][left]);
                }
            left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println(result);
    }
}
