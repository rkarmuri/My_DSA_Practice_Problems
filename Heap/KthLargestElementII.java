import java.util.PriorityQueue;

public class KthLargestElementII {

    private int K;
    private PriorityQueue<Integer> pq;
    public KthLargestElementII(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            if(pq.size() < K)   pq.offer(nums[i]);
            else if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(pq.size() < K){
            pq.offer(val);

            return pq.peek();
        }

        if(val > pq.peek()){
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1, 2, 3, 4};

        // Creating an object of KthLargest class
        KthLargestElementII kthLargest = new KthLargestElementII(k, nums);

        // Performing different operations
        System.out.println("Kth Largest element after adding 5 is: " + kthLargest.add(5));
        System.out.println("Kth Largest element after adding 2 is: " + kthLargest.add(2));
        System.out.println("Kth Largest element after adding 7 is: " + kthLargest.add(7));
    }
}
