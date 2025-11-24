package Sorting.Java;

public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        // Recurision base case
        // If low is equal to high, it means the array has only one element
        // and is already sorted, so we return.
        if(low==high) {
            return;
        }

        int mid = (low + high) / 2; // Compute the mid index
        mergeSort(arr,low,mid); // Sort the left half
        mergeSort(arr,mid+1,high); // Sort the right half
        merge(arr, low, mid, high); // Merge the sorted halves
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1]; // Size of the temporary array is the number of elements being merged from both halves
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        // Left over elements
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= high) {
            temp[index++] = arr[right++];
        }
        // Copy back to original array
        for (int i = low; i <= high; i++) {
            // As low is the starting index of the partition and it can be anywhere in the array
            // and temp doesn't start from 0, we need to adjust the index accordingly
            arr[i] = temp[i - low]; 
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(n) due to the temporary array used for merging
// This implementation uses a recursive approach to sort the array using the merge sort algorithm.
