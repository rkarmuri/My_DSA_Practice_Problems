public class Jump {
    // Intuition: Keep track of the farthest reachable index and ensure we can reach each index
    // Greedy Approach: Always jump to the farthest reachable index at each step
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Jump obj = new Jump();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(obj.canJump(nums1)); // true
        System.out.println(obj.canJump(nums2)); // false
    }
}
