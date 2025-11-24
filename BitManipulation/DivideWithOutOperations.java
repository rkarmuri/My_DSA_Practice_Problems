public class DivideWithOutOperations {
    private static int divide(int dividend, int divisor) {
        // Handle edge cases
        if(dividend == 0) return 0;
        if(divisor == 1)    return dividend;
        try
        {
            if(divisor == 0) return Integer.MAX_VALUE;
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(divisor == -1)   return -dividend;

        // Determine the sign of the result
        boolean isPositive = true;

        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isPositive = false;
        }

        // Get absolute values
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);

        int ans = 0;

        while(n >= d) {
            int count  = 0;
            while(n >= (d << count+1)) {
                count++;
            }
            ans += (1 << (count));
            n -= (d << (count));
        }

        return isPositive ? ans : -ans;
    }

    private static int divideUsingSubtraction(int dividend, int divisor) {
        // Handle edge cases
        if(dividend == 0) return 0;
        if(divisor == 1)    return dividend;
        try
        {
            if(divisor == 0) return Integer.MAX_VALUE;
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(divisor == -1)   return -dividend;

        // Determine the sign of the result
        boolean isPositive = true;

        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isPositive = false;
        }

        // Get absolute values
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);

        int ans = 0;

        while(n >= d) {
            n -= d;
            ans++;
        }

        return isPositive ? ans : -ans;
    }

    public static void main(String[] args) {
        int dividend1 = 10, divisor1 = 3;
        System.out.println("Result of " + dividend1 + " / " + divisor1 + " is: " + divide(dividend1, divisor1));

        int dividend2 = 7, divisor2 = -3;
        System.out.println("Result of " + dividend2 + " / " + divisor2 + " is: " + divide(dividend2, divisor2));

        int dividend3 = -15, divisor3 = 2;
        System.out.println("Result of " + dividend3 + " / " + divisor3 + " is: " + divideUsingSubtraction(dividend3, divisor3));

        int dividend4 = -2147483648, divisor4 = -1;
        System.out.println("Result of " + dividend4 + " / " + divisor4 + " is: " + divide(dividend4, divisor4));
    }
}
