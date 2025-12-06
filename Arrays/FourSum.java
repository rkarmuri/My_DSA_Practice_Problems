import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class FourSum {
    // Time Complexity: O(N^3), Space Complexity: O(1) excluding the space for the answer
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }

                int k = j+1, l = n-1;

                while(k<l){
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];

                    if(sum==target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);

                        k++;
                        l--;

                        while(k<l && nums[k]==nums[k-1])    k++;
                        while(k<l && nums[l]==nums[l+1])    l--;
                    }
                    else if(sum<target){
                        k++;
                    }
                    else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }

    // Using Hashing (Less Optimal), Time Complexity: O(N^3), Space Complexity: O(N)
    public List<List<Integer>> fourSumUsingHashing(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }

                HashSet<Long> set = new HashSet<>();

                for(int k=j+1;k<n;k++){
                    long sum = (long) nums[i]+nums[j]+nums[k];
                    long fourth = (long) target - sum;

                    if(set.contains(fourth)){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        ans.add(temp);

                        while(k+1<n && nums[k]==nums[k+1])    k++;
                    }

                    set.add((long) nums[k]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result);

        List<List<Integer>> resultHashing = solution.fourSumUsingHashing(nums, target);
        System.out.println(resultHashing);
    }
}
