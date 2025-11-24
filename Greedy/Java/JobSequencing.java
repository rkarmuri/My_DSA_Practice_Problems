public class JobSequencing {
    // Intuition: Sort jobs by profit and assign them to the latest available slot before their deadline
    // Greedy Approach: Always pick the job with the highest profit that can be scheduled
    private static int[] jobScheduling(int[][] jobs, int n) {
        // Time complexity: O(n log n) due to sorting
        // Space complexity: O(maxDeadline)
        // Sort jobs in descending order of profit, we are using lambda function here
        java.util.Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        // We will create a slot array of size maxDeadline to keep track of free time slots
        int maxDeadline = 0;
        for (int[] job : jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        int[] slot = new int[maxDeadline+1];
        int totalProfit = 0, countJobs = 0;

        for (int i = 0; i < jobs.length; i++) {
            // Find a free slot for this job (Note that we start from the last possible slot)
            for (int j = jobs[i][1] - 1; j >= 0; j--) {
                if (slot[j] == 0) {
                    slot[j] = jobs[i][2];
                    totalProfit += jobs[i][2];
                    countJobs++;
                    break;
                }
            }
        }

        return new int[]{countJobs, totalProfit};
    }

    // Jobs have 3 attributes: {jobId, deadline, profit}
    public static void main(String[] args) {
        int[][] jobs1 = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};
        int[][] jobs2 = {{1, 1, 100}, {2, 2, 200}, {3, 3, 300}, {4, 4, 400}};

        int[] result1 = jobScheduling(jobs1, jobs1.length);
        int[] result2 = jobScheduling(jobs2, jobs2.length);

        System.out.println("Jobs done: " + result1[0] + ", Total Profit: " + result1[1]); // Jobs done: 3, Total Profit: 30
        System.out.println("Jobs done: " + result2[0] + ", Total Profit: " + result2[1]); // Jobs done: 4, Total Profit: 1000
    }
}
