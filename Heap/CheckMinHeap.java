public class CheckMinHeap {
    public boolean isHeap(int[] nums) {
        int n = nums.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            int leftChild_Ind = 2 * i + 1;
            int rightChild_Ind = 2 * i + 2;

            if(leftChild_Ind < n && nums[leftChild_Ind] < nums[i]){
                return false;
            }
            if(rightChild_Ind < n && nums[rightChild_Ind] < nums[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23};
        
        System.out.print("Given Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
        
        // Creating an object of the Solution class
        CheckMinHeap sol = new CheckMinHeap();

        // Function call to check if the given array is a min-heap
        boolean ans = sol.isHeap(nums);

        if(ans) 
            System.out.println("\nThe given array is a min-heap.");
        else
            System.out.println("\nThe given array is not a min-heap.");
        
    }
}
