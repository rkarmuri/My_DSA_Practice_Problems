public class KokoBananas {
    public int minimumRateToEatBananas(int[] nums, int h) {
        int n = nums.length, maxi = Integer.MIN_VALUE;

        for(int i:nums){
            maxi = Math.max(i,maxi);
        }

        int low = 1, high = maxi;

        while(low<=high){
            int mid = (low+high)/2;
            if(calculateTotalHours(nums,mid)<=h){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static long calculateTotalHours(int[] nums, int hourly) {
        long totalHours = 0;
        for(int i:nums){
            totalHours += Math.ceil((double)(i)/(double)(hourly));
        }

        return totalHours;
    }

    public static void main(String[] args) {
        KokoBananas sol = new KokoBananas();
        int[] nums = {3,6,7,11};
        int h = 8;
        int result = sol.minimumRateToEatBananas(nums, h);
        System.out.println("The minimum eating rate to finish bananas in " + h + " hours is: " + result);
    }
}
