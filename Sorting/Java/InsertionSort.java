package Sorting.Java;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            /*for(int j=i;j>0&&arr[j]<arr[j-1];j--){
                swap(arr,j,j-1);
            }*/
            int j = i;
            while(j>0 && arr[j]<arr[j-1]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }

    protected static void insertionSortwithoutSwap(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i - 1;

            while(j>=0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSortRecursive(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        insertionSortRecursive(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    public static void printArray(int[] nums) {
        for(int i: nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        insertionSort(arr);
        System.out.print("Sorted array: ");
        printArray(arr);
        int[] arrRecursive = {5, 2, 9, 1, 5, 6};
        insertionSortRecursive(arrRecursive, arrRecursive.length);
        System.out.print("Sorted array using recursion: ");
        printArray(arrRecursive);
        int[] arrNoSwap = {8,3,7,4,6,2,5,9};
        insertionSortwithoutSwap(arrNoSwap);
        System.out.print("Sorted array without swapping: ");
        printArray(arrNoSwap);
    }
}


// Time complexity for Insertion sort is: O(n^2) in the worst and average cases (O(n^2/4))
// Best case time complexity is: O(n) as no swapping is needed
// Space Complexity is: O(1)