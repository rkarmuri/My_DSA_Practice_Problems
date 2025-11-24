import java.util.ArrayList;

public class SieveOfErat {
    public ArrayList<Integer> primeTillN(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        for (long i = 2; i <= n; i++) {
             if (isPrime[(int) i]) {
                ans.add((int) i);

                for (long val = i * i; val <= n; val += i){
                    isPrime[(int) val] = false;
                }
             }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int n = 19;

        SieveOfErat sol = new SieveOfErat();

        ArrayList<Integer> ans = sol.primeTillN(n);
        
        System.out.println("All primes till N are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
