package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class leaderArray {
    private static ArrayList<Integer> findLeaders(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            boolean leader = true;
            for(int j=i+1;j<n;j++){
                if(nums[i]<=nums[j]){
                    leader = false;
                    break;
                }
            }

            if(leader) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    private static ArrayList<Integer> findLeadersOptimized(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int maxFromRight = Integer.MIN_VALUE;

        for(int i=n-1;i>=0;i--){
            if(nums[i]>maxFromRight){
                ans.add(nums[i]);
                maxFromRight = nums[i];
            }
        }

        // Reversing the arraylist to maintain the order of leaders as in original array
        Collections.reverse(ans);

        return ans;
    }

    private static void printArr(ArrayList<Integer> nums) {
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 1, 2};
        ArrayList<Integer> ans = findLeaders(arr);
        ArrayList<Integer> optimizedAns = findLeadersOptimized(arr);
        System.out.println("Leader Array is: ");
        printArr(ans);
        System.out.println("Optimized Leader Array is: ");
        printArr(optimizedAns);
    }
}
