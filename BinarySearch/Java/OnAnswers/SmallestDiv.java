public class SmallestDiv {
    public int smallestDivisor(int[] nums, int limit) {
       int n = nums.length, maxi = Integer.MIN_VALUE;

       for(int i:nums){
        maxi = Math.max(i,maxi);
       }

       int low = 1, high = maxi;

       while(low<=high){
        int mid = (low+high)/2;
        if(sumByD(nums,mid)<=limit){
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
       }

       return low;
    }

    private static int sumByD(int[] nums, int d){
        int sum = 0;

        for(int i:nums){
            sum += Math.ceil((double)(i)/(double)(d));
        }

        return sum;
    }

    public static void main(String[] args) {
        SmallestDiv sol = new SmallestDiv();
        int[] nums = {1,2,5,9};
        int limit = 6;
        int result = sol.smallestDivisor(nums, limit);
        System.out.println("The smallest divisor is: " + result);
    }
}
