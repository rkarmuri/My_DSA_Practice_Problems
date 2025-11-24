public class SearchRotatedSortedArrayI {
    public int search(int[] nums, int k) {
       int low = 0, high = nums.length - 1;

       while(low<=high){
        int mid = (low+high)/2;

        if(nums[mid]==k)    return mid;

        // Check if left subarray is sorted
        if(nums[low]<=nums[mid]){
            //Check if the target lies within left subarray
            if(nums[low]<=k && k<=nums[mid]){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        else {
            // Check if the target lies within right subarray
            if(nums[mid]<=k && k<=nums[high]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
       }

       return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArrayI sol = new SearchRotatedSortedArrayI();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = sol.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}
