package Recursion;

public class Recursion {
    public static void Recursion1(int i, int n){
        if(i<n){
            System.out.print("Raju ");
            Recursion1(i+1,n);
        }
    }
    
    public static void Recursion2(int i, int n){
        if(i<=n){
            System.out.print(i+" ");
            Recursion2(i+1,n);
        }
    }
    
    public static void Recursion3(int i, int n){
        if(i<n){
            System.out.print(n+" ");
            Recursion3(i,n-1);
        }
    }
    
    public static void Recursion4(int n, int sum){
        if(n<1){
            System.out.println(sum);
            return;
        }
        Recursion4(n-1,sum+n);
    }
    
    public static void Recursion5(int n, int fact){
        if(n<1){
            System.out.println(fact);
            return;
        }
        Recursion5(n-1,fact*n);
    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverseArray(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        swap(arr, i, j);
        reverseArray(arr, i + 1, j - 1);
    }

    public static void reverseArray2(int[] arr, int i, int n) {
        if (i >= n / 2) {
            return;
        }
        swap(arr, i, n - i - 1);
        reverseArray2(arr, i + 1, n);
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        return isPalindromeRecursive(s, 0);
    }

    private static boolean isPalindromeRecursive(String s, int i) {
        if (i >= s.length() / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
        return isPalindromeRecursive(s, i + 1);
    }

    public static int fibonacci(int n) {
        if(n<=1){
            return n;
        }
        int last = fibonacci(n-1);
        int secondLast = fibonacci(n-2);
        return last + secondLast;
    }
    
    public static void main(String[] args) {
        int N=5;
        String name = "Raju";
        System.out.print("Printing "+ name+ " "+N+ " times: ");
        Recursion1(0,5);
        System.out.println();
        System.out.print("Printing numbers from 1 to "+N+": ");
        Recursion2(1,5);
        System.out.println();
        System.out.print("Printing numbers from "+N+" to 1: ");
        Recursion3(0,5);
        System.out.println();
        System.out.print("Sum of "+ N + " numbers is: ");
        Recursion4(5,0);
        System.out.print("Factorial of "+ N + " is: ");
        Recursion5(5,1);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Reversed array using two pointers is: ");
        reverseArray(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Reversed array using one pointer is: ");
        reverseArray2(arr, 0, arr.length);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        String str = "A man, a plan, a canal: Panama";
        boolean isPalin = isPalindrome(str);
        System.out.print("Is the string \"" + str + "\" a palindrome? "+isPalin);
        System.out.println();
        int fibIndex = 7;
        System.out.print("Fibonacci number at index " + fibIndex + " is: "+ fibonacci(fibIndex));
    }
}
