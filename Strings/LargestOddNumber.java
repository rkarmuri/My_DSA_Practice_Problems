package Strings;

public class LargestOddNumber {
    private static String largestOddNumber(String s) {
        int left = 0, right = -1;
        // Traverse backwards until we find an odd number
        for(int j = s.length()-1;j>=0;j--){
            if((s.charAt(j) - '0')%2==1){
                right = j;
                break;
            }
        }

        if(right==-1){
            return "";
        }

        // Check for leading zeroes from the left
        while(left<=right && s.charAt(left)=='0'){
            left++;
        }

        return s.substring(left,right+1);
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("Largest odd number in '123456789': " + largestOddNumber("123456789")); // Output: "123456789"
        System.out.println("Largest odd number in '0000': " + largestOddNumber("0000"));           // Output: ""
        System.out.println("Largest odd number in '00013579': " + largestOddNumber("13579"));         // Output: "13579"
    }
}
