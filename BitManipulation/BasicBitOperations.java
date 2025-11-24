public class BasicBitOperations {
    private static String convertNumToBinary(int num){
        // Time complexity: O(log n)
        // Space complexity: O(1)
        if(num==0)  return "0";

        StringBuilder ans = new StringBuilder();

        while(num>0){
            ans.append(num%2);
            num /= 2;
        }

        return ans.reverse().toString();
    }

    private static int convertBinaryToDecimal(String s){
        // Time complexity: O(n)
        // Space complexity: O(1)
        int decimal = 0;
        int base = 1;
        
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1')    decimal += base;
            base *= 2;
        }
        
        return decimal;
    }

    private static void swapWithoutTemp(int a, int b){
        // Time complexity: O(1)
        // Space complexity: O(1)
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("After swapping: a = "+a+" b = "+b);
    }   

    // For checking the ith bit of a number, we can use either left shift or right shift operation
    // In both operations, we will be using 1 as the number whose bit we want to check
    // Left shift operation: (1<<i) will shift 1 to the left by i positions, creating a mask with only the ith bit set to 1
    // Right shift operation: (num>>i) will shift the bits of num to the right by i positions, bringing the ith bit to the least significant position
    // In both cases, we perform a bitwise AND operation with num to isolate the ith bit
    // If the result is not equal to 0, it means the ith bit is set (1), otherwise it is not set (0)
    private static int checkIthBitUsingLeftShift(int num, int i){
        // Time complexity: O(1)
        // Space complexity: O(1)
        return (num & (1<<i))!=0 ? 1 : 0;
    }

    private static int checkIthBitUsingRightShift(int num, int i){
        // Time complexity: O(1)
        // Space complexity: O(1)
        return (num>>i & 1)!=0 ? 1 : 0;
    }

    private static int setIthBit(int num, int i){
        // Time complexity: O(1)
        // Space complexity: O(1)
        return num | (1<<i);
    }

    private static int clearIthBit(int num, int i){
        // Time complexity: O(1)
        // Space complexity: O(1)
        return num & ~(1<<i);
    }

    private static int toggleIthBit(int num, int i){
        // Time complexity: O(1)
        // Space complexity: O(1)
        return num ^ (1<<i);
    }

    private static int removeLastSetBit(int num){
        // Time complexity: O(1)
        // Space complexity: O(1)
        //return num & (num-1);
        int ans = num - (num & -num); // alternative way to remove the last set bit,
        return ans; // where -num is 2's complement of num
    }

    private static int checkIfPowerOfTwo(int num){
        // Time complexity: O(1)
        // Space complexity: O(1)
        return (num & (num-1))==0 ? 1 : 0;
    }

    private static int countSetBits(int num){
        // Time complexity: O(k) where k is the number of set bits in num
        // Space complexity: O(1)
        int count = 0;
        while(num>0){
            num = num & (num-1);
            count++;
        }
        return count;
    }

    // Using the lowest set bit trick to count the number of set bits in a number
    private static int countSetBitsUsingLowestSetBitTrick(int num){
        // Time complexity: O(k) where k is the number of set bits in num
        // Space complexity: O(1)
        int count = 0;
        while(num>0){
            num -= num & -num; // where -num is 2's complement of num
            count++;
        }
        return count;
    }

    // Using the lowest set bit trick to find the rightmost set bit of a number
    private static int rightmostSetBitUsingLowestSetBitTrick(int num){
        // Time complexity: O(1)
        // Space complexity: O(1)
        return num & -num; // where -num is 2's complement of num
    }

    private static int rightmostSetBit(int num){
        // Time complexity: O(1)
        // Space complexity: O(1)
        int rightmostSBT = num & (num-1) ^ num;
        // int rightmostSBT = num & -num; // Alternative way to get the rightmost set bit, 
        // where -num is 2's complement of num
        return rightmostSBT;
    }

    public static void main(String[] args) {
        int num = 51;

        String res = convertNumToBinary(num);
        System.out.println("Binary number for "+num+" is: "+res);
        String binaryStr = "110011";
        int decimal = convertBinaryToDecimal(binaryStr);
        System.out.println("Decimal number for "+binaryStr+" is: "+decimal);
        int a = 5, b = 10;
        System.out.println("Before swapping: a = "+a+" b = "+b);
        swapWithoutTemp(a, b);
        int n = 13, i = 2, j = 1;
        System.out.println("Using left shift: The "+i+"th bit of "+n+" is: "+checkIthBitUsingLeftShift(n, i));
        System.out.println("Using right shift: The "+i+"th bit of "+n+" is: "+checkIthBitUsingRightShift(n, i));
        int newNum = setIthBit(n, j);
        System.out.println("After setting the "+j+"th bit of "+n+", the new number is: "+newNum);
        newNum = clearIthBit(n, i);
        System.out.println("After clearing the "+i+"th bit of "+n+", the new number is: "+newNum);
        newNum = toggleIthBit(n, j);
        System.out.println("After toggling the "+j+"th bit of "+n+", the new number is: "+newNum);
        newNum = removeLastSetBit(n);
        System.out.println("After removing the last set bit of "+n+", the new number is: "+newNum);
        int powerOfTwoCheck = 16;
        System.out.println("Is "+powerOfTwoCheck+" a power of two? : "+(checkIfPowerOfTwo(powerOfTwoCheck)==1 ? "Yes" : "No"));
        int countSetBitsInNum = 29;
        System.out.println("Number of set bits in "+countSetBitsInNum+" is: "+countSetBits(countSetBitsInNum));
        int countSetBitsUsingLSTInNum = 29;
        System.out.println("Number of set bits in "+countSetBitsUsingLSTInNum+" using lowest set bit trick is: "+countSetBitsUsingLowestSetBitTrick(countSetBitsUsingLSTInNum));
        int rightmostSetBitUsingLST = 18;
        System.out.println("Rightmost set bit of "+rightmostSetBitUsingLST+" is: "+rightmostSetBitUsingLowestSetBitTrick(rightmostSetBitUsingLST));
        int rightmostSetBitInNum = 18;
        System.out.println("Rightmost set bit of "+rightmostSetBitInNum+" using the lowest set bit trick is: "+rightmostSetBit(rightmostSetBitInNum));
    }
}
