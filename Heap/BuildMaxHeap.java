import java.util.Arrays;

public class BuildMaxHeap {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        for(int i = n/2 - 1; i >= 0; i--){
            heapifyDown(nums, i);
        }

        return nums;
    }

    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length; 

        // Index of smallest element
        int largestInd = ind;

        // Indices of the left and right children
        int leftChild_Ind = 2 * ind + 1;
        int rightChild_Ind = 2 * ind + 2;

        // If the left child holds a smaller value, update the smallest index
        if (leftChild_Ind < n && arr[leftChild_Ind] > arr[largestInd]) {
            largestInd = leftChild_Ind;
        }

        // If the right child holds a smaller value, update the smallest index
        if (rightChild_Ind < n && arr[rightChild_Ind] > arr[largestInd]) {
            largestInd = rightChild_Ind;
        }

        // If the smallest element index is updated
        if (largestInd != ind) {
            // Swap the smallest element with the current index
            int temp = arr[largestInd];
            arr[largestInd] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, largestInd);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 7, 6, 7};

        // Input array
        System.out.println("Input array: " + Arrays.toString(nums));

        // Creating an object of the Solution class
        BuildMaxHeap sol = new BuildMaxHeap();

        // Function call to convert the given array into a min-heap
        sol.minToMaxHeap(nums);

        // Output array
        System.out.println("Min-heap array: " + Arrays.toString(nums));
    }
}
