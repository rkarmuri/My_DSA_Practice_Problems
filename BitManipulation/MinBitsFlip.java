public class MinBitsFlip {
    public static void main(String[] args) {
        int a = 29; // 11101
        int b = 15; // 01111
        System.out.println("Minimum bits to flip to convert " + a + " to " + b + " is: " + minBitsToFlip(a, b));
        System.out.println("Minimum bits to flip to convert " + a + " to " + b + " (one line solution) is: " + minBitsToFlipOneline(a, b));
        System.out.println("Minimum bits to flip to convert " + a + " to " + b + " (32 iterations) is: " + minBitsToFlip32Iter(a, b));
    }

    private static int minBitsToFlip(int a, int b) {
        // Using Brian Kernighan’s Algorithm
        // Time complexity: O(k) where k is the number of bits that are different between a and b
        // Space complexity: O(1)
        int count = 0;
        int xor = a ^ b;
        while (xor!=0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    // Using 32 iterations
    private static int minBitsToFlip32Iter(int a, int b) {
        // Time complexity: O(32) since it always runs 32 iterations
        // Space complexity: O(1)
        int count = 0;
        int xor = a ^ b;
        for (int i = 0; i < 32; i++) {
            if ((xor>>i & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    // On line solution is
    private static int minBitsToFlipOneline(int a, int b) {
        // Time complexity: O(1)
        // Space complexity: O(1)
        return Integer.bitCount(a ^ b);
    }
}
