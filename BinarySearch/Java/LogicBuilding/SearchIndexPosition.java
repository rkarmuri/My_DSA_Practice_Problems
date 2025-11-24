package BinarySearch.Java.LogicBuilding;

public class SearchIndexPosition {
    private static int searchIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) {
                return mid; // Found the target
            } else if(arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return low; 
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int target = 20;

        System.out.println("Index of " + target + " is: " + searchIndex(arr, target));
    }
}
