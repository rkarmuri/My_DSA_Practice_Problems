public class FindNthRoot {
    public int NthRoot(int N, int M) {
        int low = 1, high = M;
        while (low <= high) {
            int mid = (low + high) / 2;
            long val = Power(mid, N, M); // fixed order

            if (val == M) {
                return mid;
            } else if (val > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static long Power(int base, int exp, int limit) {
        long ans = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans *= base;
                if (ans > limit) return limit + 1; // safe cutoff
            } else {
                exp /= 2;
                if ((long) base * base > limit) return limit + 1;
                base *= base;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NthRoot sol = new NthRoot();
        int N = 3;
        int M = 27;
        int result = sol.NthRoot(N, M);
        System.out.println("The " + N + "th root of " + M + " is: " + result);
    }
}
