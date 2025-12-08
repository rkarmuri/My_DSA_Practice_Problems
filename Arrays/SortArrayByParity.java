public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        // Time Complexity: O(n), Space Complexity: O(1)
        int left = 0, right = nums.length - 1;

        while(left < right){
            if(nums[left] % 2 != 0){
                if(nums[right] % 2 == 0){
                    swap(nums, left, right);
                    left++;
                } else {
                    right--;
                }
            } else{
                left++;
            }
        }

        return nums;
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        SortArrayByParity sorter = new SortArrayByParity();
        int[] nums = {3, 1, 2, 4};
        int[] sorted = sorter.sortArrayByParity(nums);
        for(int num : sorted){
            System.out.print(num + " ");
        }
    }
}
