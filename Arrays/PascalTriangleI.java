public class PascalTriangleI {
    // Find the rth row and cth column value in Pascal's Triangle
    // Time Complexity: O(r), Space Complexity: O(1)
    public int getValue(int r, int c) {
        return nCr(r - 1, c - 1); // Because nCr is equal to r-1 C c-1
    }

    public int nCr(int n, int r) {
        // Base condition when r is 0 or r equals n
        if(r == 0 || r == n){
            return 1;
        }

        // Because of symmetry nCr = nC(n-r)
        if(r > n - r){
            r = n - r;
        }

        int res = 1;
        for(int i = 0; i < r; i++){
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalTriangleI pascalTriangle = new PascalTriangleI();
        int r = 11, c = 6;
        int value = pascalTriangle.getValue(r, c);
        System.out.println("Value at row " + r + " and column " + c + " in Pascal's Triangle is: " + value);
    }
}
