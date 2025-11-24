package Arrays;

public class rearrangeBySign {
    private static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[posIndex] = nums[i];
                posIndex += 2;
            } else {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3, -2, -5, 1, 4, -3};
        int[] rearranged = rearrangeArray(arr);
        for (int num : rearranged) {
            System.out.print(num + " ");
        }
        System.err.println();
    }
}
