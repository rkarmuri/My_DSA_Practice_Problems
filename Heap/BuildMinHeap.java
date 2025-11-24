import java.util.Arrays;

public class BuildMinHeap {
    public void buildMinHeap(int[] nums) {
        int n = nums.length;

        for(int i = n/2 - 1; i >= 0; i--){
            heapifyDown(nums, i);
        }
    }

    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length; 

        // Index of smallest element
        int smallest_Ind = ind;

        // Indices of the left and right children
        int leftChild_Ind = 2 * ind + 1;
        int rightChild_Ind = 2 * ind + 2;

        // If the left child holds a smaller value, update the smallest index
        if (leftChild_Ind < n && arr[leftChild_Ind] < arr[smallest_Ind]) {
            smallest_Ind = leftChild_Ind;
        }

        // If the right child holds a smaller value, update the smallest index
        if (rightChild_Ind < n && arr[rightChild_Ind] < arr[smallest_Ind]) {
            smallest_Ind = rightChild_Ind;
        }

        // If the smallest element index is updated
        if (smallest_Ind != ind) {
            // Swap the smallest element with the current index
            int temp = arr[smallest_Ind];
            arr[smallest_Ind] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, smallest_Ind);
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 2, 7, 1, 7};

        // Input array
        System.out.println("Input array: " + Arrays.toString(nums));

        // Creating an object of the Solution class
        BuildMinHeap sol = new BuildMinHeap();

        // Function call to convert the given array into a min-heap
        sol.buildMinHeap(nums);

        // Output array
        System.out.println("Min-heap array: " + Arrays.toString(nums));
    }
}
