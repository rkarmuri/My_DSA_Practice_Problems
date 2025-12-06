import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class ThreeSum {
    // Brute Force Approach: O(n^3) time complexity
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(triplet);
                    }   
                }
            }
        }
        return new ArrayList<>(result);
    }
    // Better Approach: O(n^2) time complexity using HashSet
    public static List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = - (nums[i] + nums[j]);
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }

    // Optimal Approach: O(n^2)+O(nlogn) time complexity
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSumBruteForce(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        System.out.println("Better Approach Results:");
        result = threeSumBetter(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        System.out.println("Optimal Approach Results:");
        result = threeSumOptimal(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
