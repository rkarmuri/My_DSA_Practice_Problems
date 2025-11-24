import java.util.ArrayList;
import java.util.Arrays;

public class SearchRotatedSortedArrayII {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
      int low = 0, high = nums.size() - 1;

       while(low<=high){
        int mid = (low+high)/2;

        if(nums.get(mid)==k)    return true;

        if(nums.get(low)==nums.get(mid)&&nums.get(mid)==nums.get(high)){
            low++;
            high--;
            continue;
        }

        // Check if left subarray is sorted
        if(nums.get(low)<=nums.get(mid)){
            //Check if the target lies within left subarray
            if(nums.get(low)<=k && k<=nums.get(mid)){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        else {
            // Check if the target lies within right subarray
            if(nums.get(mid)<=k && k<=nums.get(high)){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
       }

       return false;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArrayII sol = new SearchRotatedSortedArrayII();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2,5,6,0,0,1,2));
        int target = 0;
        boolean result = sol.searchInARotatedSortedArrayII(nums, target);
        System.out.println("Index of target " + target + " is found: " + result);
    }
}
