import java.util.HashMap;
import java.util.Map;

public class SumHighestAndLowest {
    public int sumHighestAndLowestFrequency(int[] nums) {
        int maxFreq = 0, minFreq = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        // Store the elements in Hashmap
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        // Traverse across the Hashmap
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int freq = entry.getValue();

            maxFreq = Math.max(maxFreq,freq);
            minFreq = Math.min(minFreq,freq);
        }

        return maxFreq+minFreq;
    }

    public static void main(String[] args) {
        SumHighestAndLowest obj = new SumHighestAndLowest();
        int[] arr = {1, 3, 2, 3, 4, 2, 2, 3, 1, 3};
        int result = obj.sumHighestAndLowestFrequency(arr);
        System.out.println("The sum of highest and lowest occurring elements is: " + result);
    }
}
