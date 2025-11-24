package Basics;
import java.util.ArrayList;
import java.util.Collections;

class Maths {
    
    public static int countDigits(int num){
        int count=0;
        while(num>0){
            num = num/10;
            count++;
        }
        return count;
    }
    
    public static int ReverseNum(int num){
        int digit,rev=0;
        while(num>0){
            digit = num%10;
            rev = rev*10 + digit;
            num = num/10;
        }
        return rev;
    }
    
    public static boolean palindromeNum(int num){
        int digit,rev=0,dup=num;
        while(num>0){
            digit = num%10;
            rev = rev*10 + digit;
            num = num/10;
        }
        
        if(rev==dup){
            return true;
        }
        return false;
    }
    
    public static boolean armstrongNum(int num){
        int digit,sum=0,dup=num;
        while(num>0){
            digit = num%10;
            sum += Math.pow(digit,3);
            num = num/10;
        }
        
        if(sum==dup){
            return true;
        }
        return false;
    }
    
    public static void printDivisors(int num){
        for(int i=1;i<=num;i++){
            if(num%i==0){
                System.out.print(i+" ");
            }    
        }
    }
    
    public static void printDivisorsOptimal(int num){
        int sqrtN = (int) Math.sqrt(num);
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i=1;i<=sqrtN;i++){
            if(num%i==0){
                divisors.add(i);
                if(num/i!=i){
                        divisors.add(num/i);
                }
            }
        }
        Collections.sort(divisors);
        for(int i:divisors){
            System.out.print(i+" ");
        }
    }
    
    public static boolean isPrime(int num){
        int sqrtN = (int) Math.sqrt(num),count=0;
        for(int i=1;i<=sqrtN;i++){
            if(num%i==0){
                count++;
                if(num/i!=i){
                    count++;
                }
            }
        }
        if(count>2){
            return false;
        }
        return true;
    }

    public static int gcd(int num1, int num2) {
        int gcd = 1;
        if(num1==0) return num2;
        if(num2==0) return num1;
        int mini = Math.min(num1,num2);
        for(int i=1;i<=mini;i++) {
            if(num1%i==0&&num2%i==0){
                gcd = i;
            }
        }
        return gcd;
    }

    // Euclidean algorithm for GCD
    public static int gcdEuclidean(int a, int b) {
        if (b == 0) {
            return a;
        }
        else if (a == 0) {
            return b;
        }
        return gcdEuclidean(b, a % b);
    }
    
    public static void main(String[] args) {
        int num = 365, num2=153, num3=36,num4=24;
        int digits = countDigits(num);
        System.out.println("No of digits in the number "+num+" are: "+digits);
        int reversedNum = ReverseNum(num);
        System.out.println("Reverse of the number "+num+" is: "+reversedNum);
        boolean reversedNum2 = palindromeNum(num);
        System.out.println("Is the number "+num+" a palindrome? "+ reversedNum2);
        boolean reversedNum3 = armstrongNum(num2);
        System.out.println("Is the number "+num2+" an armstrong? "+ reversedNum3);
        System.out.print("The divisors of "+num3+" are: ");
        printDivisorsOptimal(num3);
        System.out.println();
        System.out.print("Is "+num4+" a prime number? ");
        boolean res = isPrime(num4);
        System.out.println(res);
        int gcdNum = gcd(num3,num4);
        System.out.println("GCD is: "+gcdNum);
        int gcdNum2 = gcdEuclidean(num3,num4);
        System.out.println("GCD using Euclidean algorithm is: "+gcdNum2);
    }
}