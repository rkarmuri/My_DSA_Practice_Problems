public class MaximumCardPoints {
    private static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lSum = 0, rSum = 0, maxSum = 0;

        // Calculate the sum of the first k cards from the left
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }

        maxSum = lSum;

        if(k == n) {
            return maxSum;
        }

        int rIndex = n - 1;
        // Slide the window from left to right
        for (int i = k - 1; i >= 0; i--) {
            lSum -= cardPoints[i]; // Remove one card from the left
            rSum += cardPoints[rIndex--]; // Add one card from the right
            maxSum = Math.max(maxSum, lSum + rSum); // Update maxSum if the current sum is greater
        } 
        return maxSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println("Maximum score: " + maxScore(cardPoints, k)); // Output: 12
    }
}
