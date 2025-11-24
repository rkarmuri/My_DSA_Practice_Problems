package BinarySearch.Java.Fundamental;

public class UpperBound {
    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > target) {
                ans = mid; // Found a potential upper bound
                high = mid - 1; // Move left to find a smaller value
            } else {
                low = mid + 1; // Move right to find a larger value
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int target = 2;

        System.out.println("Upper Bound of " + target + " is at index: " + upperBound(arr, target));
    }
}
