public class SubarraysSumDivisibleK {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int[] modCount = new int[k];
        modCount[0] = 1; // There's one way to have a sum of 0 (empty subarray)

        for (int num : nums) {
            sum += num;
            int mod = ((sum % k) + k) % k; // Handle negative mods
            count += modCount[mod];
            modCount[mod]++;
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraysSumDivisibleK solution = new SubarraysSumDivisibleK();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = solution.subarraysDivByK(nums, k);
        System.out.println("Number of subarrays divisible by " + k + ": " + result);
    }
}
