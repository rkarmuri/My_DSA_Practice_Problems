import java.util.ArrayList;

public class MinOfRotatedSortedArray {
    public int findMin(ArrayList<Integer> arr) {
      int low = 0, high = arr.size() - 1, ans = Integer.MAX_VALUE;

      while(low<=high){
        int mid = (low+high)/2;

        // Check if low is less than high
        if(arr.get(low)<=arr.get(high)){
            ans = Math.min(ans,arr.get(low));
            break;
        }

        // Check if left subarray is sorted
        if(arr.get(low)<=arr.get(mid)){
            ans = Math.min(ans,arr.get(low));
            low = mid + 1;
        }
        else {
            ans = Math.min(ans,arr.get(mid));
            high = mid - 1;
        }
      }

      return ans;

    }

    public static void main(String[] args) {
        MinOfRotatedSortedArray sol = new MinOfRotatedSortedArray();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        int result = sol.findMin(nums);
        System.out.println("Minimum element in the rotated sorted array: " + result);
    }
}
