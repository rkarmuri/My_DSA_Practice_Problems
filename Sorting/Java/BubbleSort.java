package Sorting.Java;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for(int i=n-1;i>0;i--){
            swapped = false;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if(!swapped) {
                break; // If no elements were swapped, the array is sorted
            }
        }
    }

    public static void bubbleSortRecursive(int[] arr, int n) {
        // Base case: if the array size is 1, return
        if (n == 1) {
            return;
        }
        boolean swapped = false;
        // One pass of bubble sort: largest element moves to end
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                swapped = true;
            }
        }

        // Recursive call for the rest of the array
        if (!swapped) {
            return; // If no elements were swapped, the array is sorted
        }
        bubbleSortRecursive(arr, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Bubble Sorted array is: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        bubbleSortRecursive(arr2, arr2.length);
        System.out.println("\nBubble Sorted array using recursion is: ");
        for(int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Time complexity for Bubble sort is: O(n^2) in the worst and average cases
// Best case time complexity is: O(n) as no swapping is needed
// Space Complexity is: O(1)
