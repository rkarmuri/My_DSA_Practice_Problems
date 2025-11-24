public class HeapSort {
    public void heapSort(int[] nums) {
        int n = nums.length;
        buildMaxHeap(nums);
        int last = n - 1;
        while(last > 0){
            swap(nums, last, 0);
            last--;
            if(last > 0)    heapifyDown(nums, last, 0);
        }

        return;
    }

    public void buildMaxHeap(int[] nums){
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i--){
            heapifyDown(nums, n - 1, i);
        }
    }

    public void heapifyDown(int[] nums, int last, int index){
        int largestInd = index;

        int leftChild_Ind = 2 * index + 1;
        int rightChild_Ind = 2 * index + 2;

        if(leftChild_Ind <= last && nums[leftChild_Ind] > nums[largestInd]){
            largestInd = leftChild_Ind;
        }
        if(rightChild_Ind <= last && nums[rightChild_Ind] > nums[largestInd]){
            largestInd = rightChild_Ind;
        }

        if(largestInd != index){
            swap(nums, largestInd, index);
            heapifyDown(nums, last, largestInd);
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {60, 30, 40, 20, 10, 50};
        
        System.out.print("Input Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
        
        // Creating an object of Solution class
        HeapSort sol = new HeapSort();
        
        // Function call to sort the array using heap-sort
        sol.heapSort(nums);
        
        System.out.print("\nSorted Array: ");
        for(int x : nums) {
            System.out.print(x + " ");
        }
    }
}
