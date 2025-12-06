import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // Time Complexity: O(n), Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(mpp.containsKey(diff)){
                return new int[]{mpp.get(diff), i};
            } else {
                mpp.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }

    // Sorted Array Approach: O(nlogn) + O(n) time complexity, O(1) space complexity
    public int[] twoSumSorted(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // Extreme naive solution: O(n^2) time complexity, O(1) space complexity
    public int[] twoSumNaive(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");

        int[] sortedResult = ts.twoSumSorted(nums, target);
        System.out.println("Sorted Indices: [" + sortedResult[0] + ", " + sortedResult[1] + "]");  

        int[] naiveResult = ts.twoSumNaive(nums, target);
        System.out.println("Naive Indices: [" + naiveResult[0] + ", " + naiveResult[1] + "]");
    }
}
