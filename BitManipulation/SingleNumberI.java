import java.util.HashMap;
public class SingleNumberI {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        System.out.println("Single number in array {2, 2, 1} is: " + singleNumber(nums1));

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single number in array {4, 1, 2, 1, 2} is: " + singleNumberHashing(nums2));

        int[] nums3 = {1};
        System.out.println("Single number in array {1} is: " + singleNumberHashing(nums3));
    }

    private static int singleNumber(int[] nums) {
        // Using XOR operation
        // Time complexity: O(n) where n is the length of the array
        // Space complexity: O(1)
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    private static int singleNumberHashing(int[] nums) {
        // Using HashMap to count occurrences
        // Time complexity: O(n) where n is the length of the array
        // Space complexity: O(n) in the worst case if all elements are unique
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (HashMap.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1; // This line should never be reached
    }
}
