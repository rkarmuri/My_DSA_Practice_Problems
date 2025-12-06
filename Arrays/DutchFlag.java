import java.util.Arrays;

public class DutchFlag {
    // Time Complexity: O(N), Space Complexity: O(1)
    public void dutchFlagSort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high]
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    // Naive Approach (Using Sorting), Time Complexity: O(N log N), Space Complexity: O(1)
    public void dutchFlagSortNaive(int[] arr) {
        Arrays.sort(arr);
    }

    // Count Occurrences, Time Complexity: O(N), Space Complexity: O(1)
    public void dutchFlagSortCounting(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else if (num == 2) count2++;
        }

        int index = 0;
        while (count0-- > 0) arr[index++] = 0;
        while (count1-- > 0) arr[index++] = 1;
        while (count2-- > 0) arr[index++] = 2;
    }

    public static void main(String[] args) {
        DutchFlag sorter = new DutchFlag();
        int[] arr = {2, 0, 1, 2, 1, 0};
        System.out.println("Optimal Dutch National Flag Sort:");
        sorter.dutchFlagSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] arr2 = {2, 0, 1, 2, 1, 0};
        System.out.println("Naive Dutch National Flag Sort:");
        sorter.dutchFlagSortNaive(arr2);
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] arr3 = {2, 0, 1, 2, 1, 0};
        System.out.println("Counting Dutch National Flag Sort:");
        sorter.dutchFlagSortCounting(arr3);
        for (int num : arr3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
