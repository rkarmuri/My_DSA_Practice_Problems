public class XORRange {
    private static int xorFrom1ToN(int n) {
        // Time complexity: O(1)
        // Space complexity: O(1)
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }

    private static int xorInRange(int l, int r) {
        // Time complexity: O(1)
        // Space complexity: O(1)
        return xorFrom1ToN(r) ^ xorFrom1ToN(l - 1); // l-1 because we need to exclude [1, l-1] from [1, r]
    }

    // Naive approach (for understanding)
    private static int xorInRangeNaive(int l, int r) {
        // Time complexity: O(n) where n is the number of elements in the range [l, r]
        // Space complexity: O(1)
        int result = 0;
        for (int i = l; i <= r; i++) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int l = 3, r = 9;
        System.out.println("XOR from " + l + " to " + r + " is: " + xorInRange(l, r));
        System.out.println("XOR from " + l + " to " + r + " using naive approach is: " + xorInRangeNaive(l, r));
    }
}
