package BinarySearch.Java.LogicBuilding;

public class FloorCeil {
    private static int[] findFloorAndCeil(int[] nums, int x) {
        int floor = findFloor(nums,x);
        int ceil = findCeil(nums,x);
        return new int[]{floor, ceil};
    }

    private static int findFloor(int[] nums, int x) {
        int ans = -1, low = 0, high = nums.length - 1;

        while(low<=high){
            int mid = (low + high) / 2;
            if(nums[mid]<=x){
                ans = nums[mid]; // Update floor
                low = mid + 1; // Search in the right half
            }else{
                high = mid - 1; // Search in the left half
            }
        }
        return ans;
    }

    private static int findCeil(int[] nums, int x) {
        int ans = -1, low = 0, high = nums.length - 1;

        while(low<=high){
            int mid = (low + high) / 2;
            if(nums[mid]>=x){
                ans = nums[mid]; // Update ceil
                high = mid - 1; // Search in the left half
            }else{
                low = mid + 1; // Search in the right half
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;

        int[] result = findFloorAndCeil(nums, x);
        System.out.println("Floor: " + result[0] + ", Ceil: " + result[1]);
    }
}
