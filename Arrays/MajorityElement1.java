import java.util.HashMap;

public class MajorityElement1 {
    public int findMajorityElement(int[] nums) {
        // Extreme Naive Approach -> Time Complexity: O(N^2), Space Complexity: O(1)
        int threshold = nums.length / 2;
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > threshold) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    // Better Approach using HashMap -> Time Complexity: O(N), Space Complexity: O(N)
    public int findMajorityElementUsingHashMap(int[] nums) {
        int threshold = nums.length / 2;
        int ans = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > threshold) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    // Optimal soluion is using counting method (Boyer-Moore Voting Algorithm)
    public int findMajorityElementOptimal(int[] nums){
        int cnt = 0, ele = 0;

        for(int num : nums){
            if(cnt == 0){
                ele = num;
            }
            if(num == ele){
                cnt++;
            } else {
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int num : nums){
            if(num == ele){
                cnt1++;
            }
    }

        if(cnt1 > nums.length / 2){
            return ele;
        } 

        return -1; // No majority element found
    }

    public static void main(String[] args) {
        MajorityElement1 majorityElement1 = new MajorityElement1();
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement1.findMajorityElement(nums);
        System.out.println("Majority Element is: " + result);
        int resultHashMap = majorityElement1.findMajorityElementUsingHashMap(nums);
        System.out.println("Majority Element using HashMap is: " + resultHashMap);
        int resultOptimal = majorityElement1.findMajorityElementOptimal(nums);
        System.out.println("Majority Element using Optimal Approach is: " + resultOptimal);
    }
}
