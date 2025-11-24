package Sorting.Java;

public class SelectionSort {
    // Selecting the minimum and swapping it with the first unsorted element
    public static void selectionSorted(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int minIndex = i; // Assume the first element is the minimum
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }
            if(minIndex != i) swap(arr, i, minIndex); // Swap the found minimum element with the first unsorted element
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {38,15,26,4,43,8,19,37,49,2};
        selectionSorted(arr);
        System.out.print("Sorted array: ");
        for(int i: arr)  System.out.print(i + " ");
        System.out.println();
    }
}

// Time Complexity: O(n^2) in all cases (best, average, worst)
// Space Complexity: O(1) as it sorts in place
// This implementation of Selection Sort is stable and sorts the array in ascending order.
