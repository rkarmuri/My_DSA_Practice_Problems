public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,1,3,2,5};
        int[] result1 = singleNumber(nums1);
        System.out.println("The two single numbers in array {1,2,1,3,2,5} are: " + result1[0] + " and " + result1[1]);

        int[] nums2 = {-1,0};
        int[] result2 = singleNumber(nums2);
        System.out.println("The two single numbers in array {-1,0} are: " + result2[0] + " and " + result2[1]);

        int[] nums3 = {0,1,0,1,2,3};
        int[] result3 = singleNumberUsingHashing(nums3);
        System.out.println("The two single numbers in array {0,1,2,3} using Hashing are: " + result3[0] + " and " + result3[1]);
    }

    private static int[] singleNumber(int[] nums) {
        // Using XOR to find the two single numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Get the rightmost set bit because the two unique numbers must differ at this bit
        int rightmostSetBit = xor & -xor;
        int b1 = 0, b2 = 0; // b1 and b2 are the two unique numbers
        // Divide numbers into two groups based on the rightmost set bit and XOR them separately
        
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                b1 ^= num;
            } else {
                b2 ^= num;
            }
        }

        if(b1 < b2) {
            return new int[]{b1, b2};
        }
        return new int[]{b1, b2};
    }

    private static int[] singleNumberUsingHashing(int[] nums) {
        // Using HashMap to count occurrences
        // Time complexity: O(n) where n is the length of the array
        // Space complexity: O(n) in the worst case if all elements are unique
        java.util.HashMap<Integer, Integer> countMap = new java.util.HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[2];
        int index = 0;
        for (java.util.Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result[index++] = entry.getKey();
                if(index == 2) break; // We only need two unique numbers
            }
        }
        return result;
    }
}
