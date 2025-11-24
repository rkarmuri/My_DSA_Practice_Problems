public class BookAllocation {
    public int findPages(int[] nums, int m) {
        int n = nums.length;

        // Edge case
        if(m>n) return -1;

        int low = Integer.MIN_VALUE, high = 0;

        // Find the minimum and maximum limits
        for(int i:nums){
            low = Math.max(i,low);
            high += i;
        }

        // We need to allocate all pages to the students given
        while(low<=high){
            int mid = (low+high)/2;
            if(countStudents(nums,mid)>m){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static int countStudents(int[] nums, int pages){
        int cntStudents = 1, pagesStudent = 0;

        for(int i=0;i<nums.length;i++){
            if(pagesStudent + nums[i]<=pages){
                pagesStudent += nums[i];
            }
            else {
                cntStudents++;
                pagesStudent = nums[i];
            }
        }

        return cntStudents;
    }

    public static void main(String[] args) {
        BookAllocation sol = new BookAllocation();
        int[] nums = {12,34,67,90};
        int m = 2;
        int result = sol.findPages(nums, m);
        System.out.println("Minimum number of pages allocated to a student: " + result);
    }
}
