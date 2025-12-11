public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Find the first decreasing element from the end
        for(int i = n - 2;i >= 0;i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }

        // If no such element is found, reverse the entire array and return
        if(index == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        // Find the first element larger than nums[index] from the end
        for(int i = n - 1;i > index; i--){
            if(nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }

        // Reverse the elements after index
        reverse(nums, index + 1, n - 1);
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        np.nextPermutation(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
