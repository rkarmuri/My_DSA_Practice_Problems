import java.util.Arrays;
import java.util.HashSet;

public class LongestSubsequence {
    private static int findLongestSubsequenceBrute(int[] arr) {
        int n = arr.length, cnt = 1, maxCount = 1;

        if(n==0)    return 0;

        Arrays.sort(arr);
        for(int i = 1; i<n;i++){
            if(arr[i-1]==arr[i])    continue;
            else if(arr[i]-arr[i-1]==1){
                cnt++;
                maxCount = Math.max(maxCount, cnt);
            }
            else {
                cnt = 1;
            }
        }
        
        return maxCount;
    }

    private static int findLongestSubsequenceOptimal(int[] arr) {
        int n = arr.length, longest = 1;

        HashSet<Integer> set = new HashSet<>();

        for(int i:arr){
            set.add(i);
        }

        for(int i = 0; i<n;i++){
            int currentNum = arr[i], cnt = 1;
            if(!set.contains(arr[i]-1)){
                while(set.contains(currentNum+1)){
                    cnt++;
                    currentNum = currentNum+1;
                }
                longest = Math.max(cnt,longest);

            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,6,3,1,7,8,2,8,9};
        int result = findLongestSubsequenceBrute(arr);
        int result2 = findLongestSubsequenceOptimal(arr);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
        System.out.println("Length of Longest Increasing Subsequence: " + result2);
    }
}
