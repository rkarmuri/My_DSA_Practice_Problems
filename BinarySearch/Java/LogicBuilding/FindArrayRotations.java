import java.util.ArrayList;

public class FindArrayRotations {
    public int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If subarray is already sorted
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                break;
            }

            // Left half is sorted
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                low = mid + 1;
            }
            // Right half is sorted
            else {
                if (nums.get(mid) < ans) {
                    ans = nums.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        FindArrayRotations sol = new FindArrayRotations();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(15);
        nums.add(18);
        nums.add(2);
        nums.add(3);
        nums.add(6);
        nums.add(12);
        int result = sol.findKRotation(nums);
        System.out.println("Array is rotated " + result + " times.");
    }
}
