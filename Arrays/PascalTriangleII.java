public class PascalTriangleII {
    // Find the rth row of Pascal's Triangle
    // Time Complexity: O(r), Space Complexity: O(r)
    public int[] getRow(int r) {
        int[] ans = new int[r];
        ans[0] = 1;

        // ans[ith column] = ans[(i-1)th column] * (row - column) / column
        for(int i = 1; i < r; i++){
            ans[i] = (int)((long)ans[i - 1] * (r - i) / i);
        }
        return ans;
    }

    public static void main(String[] args) {
        PascalTriangleII pascalTriangle = new PascalTriangleII();
        int r = 7;
        int[] row = pascalTriangle.getRow(r);
        System.out.print("Row " + r + " of Pascal's Triangle is: ");
        for(int num : row){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
