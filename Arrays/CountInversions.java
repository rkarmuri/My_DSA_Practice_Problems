public class CountInversions {
    public static int mergeSort(int[] arr, int low, int high) {
        // Recursion base case
        if (low >= high) {
            return 0;
        }

        int mid = (low + high) / 2; // Compute the mid index
        int leftInversions = mergeSort(arr, low, mid); // Sort the left half and count inversions
        int rightInversions = mergeSort(arr, mid + 1, high); // Sort the right half and count inversions
        int splitInversions = merge(arr, low, mid, high); // Merge the sorted halves and count split inversions

        return leftInversions + rightInversions + splitInversions;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1]; // Size of the temporary array is the number of elements being merged from both halves
        int index = 0;
        int inversions = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                // There are mid - left inversions, because all remaining elements in the left subarray
                // (arr[left], arr[left+1], ..., arr[mid]) are greater than arr[right]
                // Therefore, the left numbers after the left pointer are all greater than arr[right]
                // That is why we add (mid - left + 1) to the inversion count
                inversions += (mid - left + 1);
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
        return inversions;
    }

    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Brute Force Approach: Use two loops to count inversions
    public static int countInversionsBF(int[] arr) {
        int n = arr.length;
        int inversions = 0; 

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int inversionCount = countInversions(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Number of inversions: " + inversionCount);

        int inversionCountBF = countInversionsBF(new int[]{2, 4, 1, 3, 5});
        System.out.println("Number of inversions (Brute Force): " + inversionCountBF);
    }
}
