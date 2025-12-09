import java.util.List;
import java.util.ArrayList;

public class CountSmallerTillSelf {
    // Find the count of smaller elements to the right of each element in the array
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n]; // To keep track of original indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, result, 0, n - 1);
        List<Integer> resultList = new ArrayList<>();
        for (int count : result) {
            resultList.add(count);
        }
        return resultList;

    }

    private void mergeSort(int[] nums, int[] indices, int[] result, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, indices, result, low, mid);
        mergeSort(nums, indices, result, mid + 1, high);
        merge(nums, indices, result, low, mid, high);
    }

    private void merge(int[] nums, int[] indices, int[] result, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] tempIndices = new int[high - low + 1];
        int index = 0;
        int rightCount = 0; // Count of smaller elements encountered from the right side

        while (left <= mid && right <= high) {
            if (nums[indices[right]] < nums[indices[left]]) {
                // Element from right side is smaller
                rightCount++;
                tempIndices[index++] = indices[right++];
            } else {
                // Element from left side is smaller or equal
                result[indices[left]] += rightCount; // Update count of smaller elements for this index
                tempIndices[index++] = indices[left++];
            }
        }

        // Left over elements in the left half
        while (left <= mid) {
            result[indices[left]] += rightCount; // Update count for remaining left elements
            tempIndices[index++] = indices[left++];
        }

        // Left over elements in the right half
        while (right <= high) {
            tempIndices[index++] = indices[right++];
        }

        // Copy back to original indices array
        for (int i = low; i <= high; i++) {
            indices[i] = tempIndices[i - low];
        }
    }

    public static void main(String[] args) {
        CountSmallerTillSelf counter = new CountSmallerTillSelf();
        int[] arr = {5, 2, 6, 1};
        List<Integer> result = counter.countSmaller(arr);
        // Expected output: [2, 1, 1, 0]
        for (int count : result) {
            System.out.print(count + " ");
        }

        System.out.println();
    }
}
