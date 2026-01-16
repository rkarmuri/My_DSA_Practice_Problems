import java.io.*;
import java.util.*;
import java.lang.Math;

/* Problem: Count how many numbers in an array have the property that the sum of their digits equals the factorial of the sum of their digits.
    finalsum = sum of digits of number; sum of digits must be less than 10 to compute factorial.
    Check if all digits in finalsum are present in factorial(finalsum).
*/
public class SpecialNumber {
    public static int factorialSum(int array_length, List<Integer> arr) {
        int count = 0;

        for(int i = 0; i < array_length; i++){
            int finalSum = sumOfDigits(arr.get(i));
            int factSum = factorial(finalSum);

            if(compareNums(finalSum, factSum)){
                count++;
            }
        }
         return count;
    }

    public static boolean compareNums(int num1, int num2){
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(char c : String.valueOf(num1).toCharArray()){
            set1.add(c);
        }

        for(char c : String.valueOf(num2).toCharArray()){
            set2.add(c);
        }

        return set2.containsAll(set1);
    }

    public static int sumOfDigits(int N){
        if(N < 10){
            return N;
        }

        return sumOfDigits(calculateSum(N));
    }

    public static int calculateSum(int N){
        int digitsSum = 0;

        while(N > 0){
            int digit = N % 10;
            digitsSum += digit;
            N = N / 10;
        }

        return digitsSum;
    }

    public static int factorial(int N){
        int res = 1;

        for(int i = 2; i <= N; i++){
            res = res * i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int array_length = Integer.parseInt(sc.nextLine().trim());
        
        List<Integer> arr = new ArrayList<>(array_length);
        for(int j=0; j<array_length; j++) {
            arr.add(Integer.parseInt(sc.nextLine().trim()));
        }
    
        int result = factorialSum(array_length, arr);
    
        System.out.println(result);
    }
}