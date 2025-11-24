class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;

        first = findFirstOcc(nums,target);
        last = findLastOcc(nums,target);

        return new int[] {first,last};
    }

    private static int findFirstOcc(int[] nums, int target){
        int low = 0, high = nums.length - 1, ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid]<target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static int findLastOcc(int[] nums, int target){
        int low = 0, high = nums.length - 1, ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid]<target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FirstAndLastOccurrence sol = new FirstAndLastOccurrence();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = sol.searchRange(nums, target);
        System.out.println("First and Last Occurrence of " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}