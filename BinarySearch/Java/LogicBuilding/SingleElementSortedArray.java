public class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, low = 1, high = nums.length - 2;

        if(n==1)    return nums[0];
        if(nums[0]!=nums[1])    return nums[0];
        if(nums[n-1]!=nums[n-2])    return nums[n-1];

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            // Eliminate left half if even,odd index
            if((mid%2==1 && nums[mid]==nums[mid-1])||(mid%2==0 && nums[mid]==nums[mid+1])){
                low = mid + 1;
            }
            // Otherwise Eliminate right half i.e., odd,even
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SingleElementSortedArray sol = new SingleElementSortedArray();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int result = sol.singleNonDuplicate(nums);
        System.out.println("The single non-duplicate element is: " + result);
    }
}
