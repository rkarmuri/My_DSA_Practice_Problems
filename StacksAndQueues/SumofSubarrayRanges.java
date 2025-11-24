import java.util.Arrays;
import java.util.Stack;

public class SumofSubarrayRanges {
    //Brute Force Approach
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max - min);
            }
        }
        return sum;
    }

    // Optimal Approach
    public long subArrayRangesOptimal(int[] nums) {
        long res = sumSubarrayMaxs(nums) - sumSubarrayMins(nums);

        return res;
    }
    private static int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nse, n);

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                nse[st.pop()] = i;
            }

            st.push(i);
        }

        return nse;
    }
    private static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Arrays.fill(nge, n);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nge[st.pop()] = i;
            }
            st.push(i);
        }

        return nge;
    }

    private static int[] findPSEE(int[] arr){
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(psee, -1);

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                psee[st.pop()] = i;
            }

            st.push(i);
        }

        return psee;
    }
    private static int[] findPGEE(int[] arr){
        int n = arr.length;
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(pgee, -1);

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                pgee[st.pop()] = i;
            }

            st.push(i);
        }

        return pgee;
    }
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        long sum = 0;

        for(int i = 0; i <n; i++){
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = left * right * 1L;
            long val = (freq * arr[i] * 1L);

            sum = sum + val;
        }

        return sum;
    }
    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);
        long sum = 0;

        for(int i = 0; i <n; i++){
            int left = i - pgee[i];
            int right = nge[i] - i;

            long freq = left * right * 1L;
            long val = (freq * arr[i] * 1L);

            sum = sum + val;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumofSubarrayRanges solution = new SumofSubarrayRanges();
        int[] nums = {4, -2, -3, 4, 1};
        int[] nums1 = {1,2,3};
        long result = solution.subArrayRanges(nums1);
        System.out.println("Sum of Subarray Ranges: " + result); // Output: 4
        long optimalResult = solution.subArrayRangesOptimal(nums);
        System.out.println("Sum of Subarray Ranges (Optimal): " + optimalResult);
    }
}