public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for merged array

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // Using Sorting Approach
    public void mergeUsingSorting(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right  = 0;

        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                // Swap
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
            }
            left--;
            right++;
        }
        java.util.Arrays.sort(nums1, 0, m);
        java.util.Arrays.sort(nums2);

        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays merger = new MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merger.merge(nums1, 3, nums2, 3);
        
        // Print merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] nums3 = {1, 4, 7, 0, 0, 0};
        int[] nums4 = {2, 5, 6};
        merger.mergeUsingSorting(nums3, 3, nums4, 3);   

        // Print merged array
        for (int num : nums3) {
            System.out.print(num + " ");    
        }
        System.out.println();
    }
}
