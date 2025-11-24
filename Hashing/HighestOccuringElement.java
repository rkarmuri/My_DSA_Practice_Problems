import java.util.HashMap;
import java.util.Map;

public class HighestOccuringElement {
    /**
     * Problem: Find the element that occurs the most times in the array.
     * If there is a tie, return the smallest such element.
     *
     * Approach:
     * - Use a HashMap to count the frequency of each element.
     * - Traverse the map to find the element with the highest frequency.
     * - If multiple elements have the same frequency, choose the smallest one.
     * - Time Complexity: O(n), Space Complexity: O(n)
     */
    public int mostFrequentElement(int[] nums) {
        int maxFreq = 0, maxEle = -1;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count the frequencies of the elements
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        // Traverse across the hashmap and find the largest element
        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            if(count>maxFreq){
                maxEle = num;
                maxFreq = count;
            }
            // If there is a tie in the hashmap, return the smallest number
            else if(count==maxFreq) {
                maxEle = Math.min(maxEle, num);
            }
        }

        return maxEle;
    }

    public static void main(String[] args) {
        HighestOccuringElement obj = new HighestOccuringElement();
        int[] arr = {1, 3, 2, 3, 4, 2, 2, 3, 1, 3};
        int result = obj.mostFrequentElement(arr);
        System.out.println("The highest occurring element is: " + result);
    }
}
