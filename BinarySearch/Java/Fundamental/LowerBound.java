package BinarySearch.Java.Fundamental;

public class LowerBound {
    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid] >= target){
                high = mid - 1; // Move left to find the first occurrence
            } else {
                low = mid + 1; // Move right to find a larger value
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int target = 9;

        System.out.println("Lower Bound of " + target + " is at index: " + lowerBound(arr, target));
    }
}
