package Sorting.Java;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1); // Recursively sort elements before partition
            quickSort(arr, pIndex + 1, high); // Recursively sort elements after partition
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choosing the first element as pivot
        int i = low + 1; // Start from the next element
        int j = high; // Start from the end of the array

        while (i <= j) {
            // Increment i until we find an element greater than the pivot or equal to it in duplicates
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            // Decrement j until we find an element less than or equal to the pivot
            while (j >= low && arr[j] > pivot) {
                j--;
            }
            // If i is less than j, swap the elements at i and j
            if (i < j) {
                swap(arr, i, j);
            } else {
                break; // If i is not less than j, we are done with partitioning
            }
        }
        // Swap the pivot element with the element at j
        swap(arr, low, j); // We place the pivot in its correct position
        return j; // Return the partition index
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
