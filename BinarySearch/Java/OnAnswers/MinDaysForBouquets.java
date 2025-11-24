public class MinDaysForBouquets {
    public int roseGarden(int n, int[] nums, int k, int m) {
        long val = (long) m * k;

        if(val>n)   return -1;

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE, ans = -1;

        for(int i:nums){
            mini = Math.min(i,mini);
            maxi = Math.max(i,maxi);
        }

        int low = mini, high = maxi;

        while(low<=high){
            int mid = (low+high)/2;
            if(possible(nums,mid,m,k)){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean possible(int[] nums, int day, int m, int k){
        int cnt = 0, noOfB = 0;

        for(int i:nums){
            if(i<=day){
                cnt++;
            }
            else {
                noOfB += (cnt/k);
                cnt = 0;
            }
        }

        noOfB += (cnt/k);

        return noOfB >= m;
    }

    public static void main(String[] args) {
        MinDaysForBouquets sol = new MinDaysForBouquets();
        int n = 7;
        int[] nums = {1,10,3,10,2,5,7};
        int m = 2;
        int k = 2;
        int result = sol.roseGarden(n, nums, k, m);
        System.out.println("Minimum number of days required for the banquet: " + result);
    }
}
