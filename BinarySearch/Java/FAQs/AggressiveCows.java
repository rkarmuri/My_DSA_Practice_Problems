import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int low = 0, high = nums[n] - nums[0];

        while(low<=high){
            int mid = (low+high)/2;
            if(canWePlace(nums,mid,k)==true){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }

    private static boolean canWePlace(int[] nums, int d, int k){
        int n = nums.length;
        int cntCows = 1;
        int last = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]-last>=d){
                cntCows++;
                last = nums[i];
            }

            if(cntCows>=k)  return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AggressiveCows sol = new AggressiveCows();
        int[] nums = {1,2,8,4,9};
        int k = 3;
        int result = sol.aggressiveCows(nums, k);
        System.out.println("The largest minimum distance for placing " + k + " cows is: " + result);
    }
}
