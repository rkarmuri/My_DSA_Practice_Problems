public class ReversePairs {
    public int reversePairs(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int leftPairs = mergeSort(nums, low, mid);
        int rightPairs = mergeSort(nums, mid + 1, high);
        int crossPairs = countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return leftPairs + rightPairs + crossPairs;
    }

    private int countPairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int right = mid + 1;

        for(int left = low; left <= mid; left++){
            while(right <= high && (long)nums[left] > 2 * (long)nums[right]){
                right++;
            }

            // From the pointer after mid to the current right pointer, because all the elements in between satisfy the condition
            count += (right - (mid + 1)); 
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int index = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= high) {
            temp[index++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }

    // Brute Force Approach: Use two loops to count reverse pairs
    public int reversePairsBF(int[] nums) {
        int n = nums.length;
        int reversePairs = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((long)nums[i] > 2 * (long)nums[j]) {
                    reversePairs++;
                }
            }
        }
        return reversePairs;
    }

    public static void main(String[] args) {
        ReversePairs rp = new ReversePairs();
        int[] nums = {1, 3, 2, 3, 1};
        int result = rp.reversePairs(nums);
        System.out.println("Number of reverse pairs: " + result); // Output: 2

        int[] numsBF = {1, 3, 2, 3, 1};
        int resultBF = rp.reversePairsBF(numsBF);
        System.out.println("Number of reverse pairs (Brute Force): " + resultBF);
    }
}
