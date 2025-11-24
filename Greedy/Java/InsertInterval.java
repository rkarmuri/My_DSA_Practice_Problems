public class InsertInterval {
    // Intuition: Insert the new interval in the correct position and merge if necessary
    // Greedy Approach: Always merge overlapping intervals as soon as they are found
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insert(intervals, newInterval);
        System.out.println("Intervals after insertion:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        // Time complexity: O(n) due to single pass
        // Space complexity: O(n) for the result array
        java.util.List<int[]> result = new java.util.ArrayList<>();
        int i = 0;

        // Add all intervals that come before the new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all intervals that come after the new interval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
