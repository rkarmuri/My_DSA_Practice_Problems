import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementII {
    // Optimal solution using extended Boyer-Moore Voting Algorithm
    // Time Complexity: O(N), Space Complexity: O(1)
    public List<Integer> majorityElement2(int[] nums){
        int cnt1 = 0, cnt2 = 0, ele1 = 0, ele2 = 0;
        List<Integer> ans = new ArrayList<>();

        for(int num : nums){
            if(cnt1 == 0 && ele2 != num){
                cnt1 = 1;
                ele1 = num;
            }
            else if(cnt2 == 0 && ele1 != num){
                cnt2 = 1;
                ele2 = num;
            }
            else if(num == ele1){
                cnt1++;
            }
            else if(num == ele2){
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        int mini = nums.length/3;

        for(int num : nums){
            if(num == ele1){
                cnt1++;
            }
            else if(num == ele2 && ele1 != ele2){
                cnt2++;
            }
        }

        if(cnt1 > mini){
            ans.add(ele1);
        }
        if(cnt2 > mini){
            ans.add(ele2);
        }

        return ans;
    }

    // Using HashMap, Time Complexity: O(N), Space Complexity: O(N)
    public List<Integer> majorityElement2UsingHashMap(int[] nums){
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = nums.length / 3; 
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > mini){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    // Extreme Naive Approach -> Time Complexity: O(N^2), Space Complexity: O(1)
    public List<Integer> findMajorityElementNaive(int[] nums) {
        int threshold = nums.length / 3;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > threshold && !ans.contains(nums[i])) {
                ans.add(nums[i]);
            }
        }
        return ans;
        
    }

    public static void main(String[] args) {
        MajorityElementII majorityElementII = new MajorityElementII();
        int[] nums = {1,1,1,3,3,2,2,2};
        List<Integer> result = majorityElementII.majorityElement2(nums);
        System.out.println("Optimal solution to find the majority element is: "+result); // Output: [1, 2]

        List<Integer> resultUsingHashMap = majorityElementII.majorityElement2UsingHashMap(nums);
        System.out.println("Using HashMap to find the majority element is: "+resultUsingHashMap); // Output: [1, 2]

        List<Integer> resultNaive = majorityElementII.findMajorityElementNaive(nums);
        System.out.println("Naive approach to find the majority element is: "+resultNaive); // Output: [1, 2]
    }
}
