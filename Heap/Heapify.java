public class Heapify {
    public void heapify(int[] nums, int ind, int val) {
        int n = nums.length;
        if(nums[ind] > val){
            nums[ind] = val;
            heapifyUp(nums, ind);
        } else {
            nums[ind] = val;
            heapifyDown(nums, ind, n);
        }
    }

    public void heapifyUp(int[] nums, int ind){
        int parent_Ind = (ind - 1) / 2;

        if(ind > 0 && (nums[ind] < nums[parent_Ind])){
            swap(nums, ind, parent_Ind);
            heapifyUp(nums, parent_Ind);
        }
    }

    public void heapifyDown(int[] nums, int ind, int n){
        int smallest_Ind = ind;
        int leftChild_Ind = 2 * ind + 1;
        int rightChild_Ind = 2 * ind + 2;

        if(leftChild_Ind < n && nums[leftChild_Ind] < nums[smallest_Ind]){
            smallest_Ind = leftChild_Ind;
        }

        if(rightChild_Ind < n && nums[rightChild_Ind] < nums[smallest_Ind]){
            smallest_Ind = rightChild_Ind;
        }

        if(smallest_Ind != ind){
            swap(nums, smallest_Ind, ind);

            heapifyDown(nums, smallest_Ind, n);
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        // Example array representing a min-heap
        int[] nums = {1, 4, 5, 5, 7, 6};
        int ind = 5, val = 2;

        // Print input array
        System.out.print("Input array: ");
        for (int it : nums) {
            System.out.print(it + " ");
        }

        // Create an object of the Solution class
        Heapify sol = new Heapify();

        // Function call to heapify the array
        sol.heapify(nums, ind, val);

        // Print modified array
        System.out.print("\nModified array after heapifying: ");
        for (int it : nums) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}
