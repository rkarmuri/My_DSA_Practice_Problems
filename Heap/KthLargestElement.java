import java.util.PriorityQueue;

public class KthLargestElement {
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {-5, 4, 1, 2, -3};
        int k = 5;

        // Creating an object of the Solution class
        KthLargestElement sol = new KthLargestElement();

        // Function call to get the Kth largest element 
        int ans = sol.kthLargestElement(nums, k);

        // Output array
        System.out.println("The Kth largest element in the array is: " + ans);
    }
}
