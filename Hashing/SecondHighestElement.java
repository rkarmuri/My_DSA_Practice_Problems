import java.util.HashMap;
import java.util.Map;

public class SecondHighestElement {
    public int secondMostFrequentElement(int[] nums) {
        int n = nums.length;
        int maxFreq = 0, secMaxFreq = 0;
        int maxEle = -1, secMaxEle = -1;

        // HashMap to store the keys and values
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        // Traverse across the hashmap and compare the key-value pairs
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int ele = entry.getKey();
            int freq = entry.getValue();

            if(freq>maxFreq){
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secMaxEle = maxEle;
                maxEle = ele;
            }
            else if(freq==maxFreq){
                maxEle = Math.min(maxEle, ele);
            }
            else if(freq>secMaxFreq){
                secMaxEle = ele;
                secMaxFreq = freq;
            }
            else if(freq==secMaxFreq){
                secMaxEle = Math.min(secMaxEle,ele);
            }
        }
        return secMaxEle;
    }

    public static void main(String[] args) {
        SecondHighestElement obj = new SecondHighestElement();
        int[] arr = {1, 3, 2, 3, 4, 2, 2, 3, 1, 3};
        int result = obj.secondMostFrequentElement(arr);
        System.out.println("The second highest occurring element is: " + result);
    }
}
