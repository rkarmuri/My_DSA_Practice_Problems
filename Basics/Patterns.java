package Basics;

public class Patterns {
    public static void pattern1(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void pattern2(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void pattern3(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
    public static void pattern4(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(i+1);
            }
            System.out.println();
        }
    }
    public static void pattern5(int n) {
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void pattern6(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
    public static void pattern7(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern8(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*(n-i)-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern9(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*(n-i)-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void pattern10(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print('*');
            }
            System.out.println();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void pattern11(int n) {
        for(int i=0;i<n;i++){
            int start = 1;
            if(i%2==1){
                start = 0;
            }
            for(int j=0;j<i+1;j++){
                System.out.print(start+" ");
                start = 1 - start;
            }
            System.out.println();
        }
    }
    public static void pattern12(int n) {
        n = n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(j+1);
            }
            for(int j=0;j<2*(n-i-1);j++){
                System.out.print(" ");
            }
            for(int j=i+1;j>0;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern13(int n) {
        int num = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
    public static void pattern14(int n){
        char ch = 'A';
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print((char)(ch+j));
            }
            System.out.println();
        }
    }
    public static void pattern15(int n){
        char ch = 'A';
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print((char)(ch+j));
            }
            System.out.println();
        }
    }
    public static void pattern16(int n){
        char ch = 'A';
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print((char)(ch+i));
            }
            System.out.println();
        }
    }
    public static void pattern17(int n){
        char ch = 'A';
        n = n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i+1;j++){
                System.out.print((char)(ch+j));
            }
            for(int j=0;j<i;j++){
                System.out.print((char)(ch+i-j-1));
            }
            System.out.println();
        }
    }
    public static void pattern18(int n){
        char ch = 'E';
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print((char)(ch-i+j)+" ");
            }
            System.out.println();
        }
    }
    public static void pattern19(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*(n-i-1);j++){
                System.out.print(" ");
            }
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern20(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*(n-i-1);j++){
                System.out.print(" ");
            }
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*(i+1);j++){
                System.out.print(" ");
            }
            for(int j=0;j<n-i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern21(int n){
        n = n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==n-1||j==n-1){
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
    public static void pattern22(int n){
        n = n-1;
        int boundary = 2*n-1;
        for(int i=0;i<boundary;i++){
            for(int j=0;j<boundary;j++){
                // Distance from edges
                int top = i, bottom = boundary-1-i;
                int left = j, right = boundary-1-j;
                // Find the minimum distance from edges and value = n - min distance
                int res = n - Math.min(Math.min(top,bottom),Math.min(right,left));
                System.out.print(res+"");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Pattern 1:");
        pattern1(n);
        System.out.println("Pattern 2:");
        pattern2(n);
        System.out.println("Pattern 3:");
        pattern3(n);
        System.out.println("Pattern 4:");
        pattern4(n);
        System.out.println("Pattern 5:");
        pattern5(n);
        System.out.println("Pattern 6:");
        pattern6(n);
        System.out.println("Pattern 7:");
        pattern7(n);
        System.out.println("Pattern 8:");
        pattern8(n);
        System.out.println("Pattern 9:");
        pattern9(n);
        System.out.println("Pattern 10:");
        pattern10(n);
        System.out.println("Pattern 11:");
        pattern11(n);
        System.out.println("Pattern 12:");
        pattern12(n);
        System.out.println("Pattern 13:");
        pattern13(n);
        System.out.println("Pattern 14:");
        pattern14(n);
        System.out.println("Pattern 15:");
        pattern15(n);
        System.out.println("Pattern 16:");
        pattern16(n);
        System.out.println("Pattern 17:");
        pattern17(n);
        System.out.println("Pattern 18:");
        pattern18(n);
        System.out.println("Pattern 19:");
        pattern19(n);
        System.out.println("Pattern 20:");
        pattern20(n);
        System.out.println("Pattern 21:");
        pattern21(n);
        System.out.println("Pattern 22:");
        pattern22(n);
    }
}
