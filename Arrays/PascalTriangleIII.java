import java.util.ArrayList;
import java.util.List;

public class PascalTriangleIII {
    // Generate first r rows of Pascal's Triangle
    // Time Complexity: O(n^2), Space Complexity: O(n^2)
    public List<List<Integer>> generate(int r) {
        List<List<Integer>> triangle = new java.util.ArrayList<>();

        for (int row = 1; row <= r; row++) {
            triangle.add(generateRow(row));
        }
        
        return triangle;
    }

    public List<Integer> generateRow(int row) {
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1); // First element is always 1

        // Calculate remaining elements using the formula
        // currentRow[ith column] = currentRow[(i-1)th column] * (row - column) / column
        for(int col = 1; col < row; col++){
            int val = (int)((long)currentRow.get(col - 1) * (row - col) / col);
            currentRow.add(val);
        }
        return currentRow;
    }

    public static void main(String[] args) {
        PascalTriangleIII pascalTriangle = new PascalTriangleIII();
        int r = 5;
        List<List<Integer>> triangle = pascalTriangle.generate(r);
        System.out.println("First " + r + " rows of Pascal's Triangle:");
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
