public class NmeetingsOneRoom {
    // Intution: Sort meetings by end time and select the maximum number of non-overlapping meetings
    // Greedy Choice: Always pick the next meeting that ends the earliest and is compatible with the previously selected meetings
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;
        int maxMeetings = maxMeetingsInOneRoom(start, end, n);
        System.out.println("Maximum number of meetings in one room: " + maxMeetings);
    }

    private static int maxMeetingsInOneRoom(int[] start, int[] end, int n) {
        // Time complexity: O(n log n + n) due to sorting and single pass
        // Space complexity: O(n) for storing meetings
        // Create an array of meetings
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i]; // Start time
            meetings[i][1] = end[i];   // End time
        }

        // Sort meetings based on their end time
        java.util.Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < n; i++) {
            // If the meeting starts after the last selected meeting ends
            if (meetings[i][0] > lastEndTime) {
                count++;
                lastEndTime = meetings[i][1];
            }
        }

        return count;
    }
}
