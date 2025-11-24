public class PeakElement {
    public int findPeakElement(int[] arr) {
        int n = arr.length;

        // Edge cases
        if(n==1)    return 0;
        if(arr[0]>arr[1])   return 0;
        if(arr[n - 1]>arr[n - 2]) return n - 1;

        int low = 0, high = n - 1;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid - 1]<arr[mid] && arr[mid + 1]<arr[mid]){
                return mid;
            }
            else if(arr[mid]<arr[mid + 1]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PeakElement sol = new PeakElement();
        int[] nums = {1,3,20,4,1,0};
        int result = sol.findPeakElement(nums);
        System.out.println("Index of a peak element: " + result);
    }
}
