public class NonOverlappingIntervals {
    // Intution: Sort intervals by end time and use a greedy approach to select non-overlapping intervals.
    // The minimum number of intervals to remove is the total number of intervals minus the maximum number
    // of non-overlapping intervals that can be selected.
    // Greedy choice: Always select the interval that ends the earliest and is compatible with previously selected intervals.  
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {6, 7}, {5, 8}};
        int n = intervals.length;
        int minIntervalsToRemove = minIntervalsToRemove(intervals, n);
        System.out.println("Minimum number of intervals to remove: " + minIntervalsToRemove);
    }

    private static int minIntervalsToRemove(int[][] intervals, int n) {
        // Time complexity: O(n log n)+n due to sorting and single pass
        // Space complexity: O(1) for variables
        java.util.Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return n - count;
    }
}
