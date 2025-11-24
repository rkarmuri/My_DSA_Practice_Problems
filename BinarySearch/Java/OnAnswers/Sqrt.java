public class Sqrt {
    public long floorSqrt(long n) {
      long ans = 0;

      long low = 1, high = n;

      while(low<=high){
        long mid = (low+high)/2;
        if(mid*mid<=n){
            ans = mid;
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
      }

      return ans;
    }

    public static void main(String[] args) {
        Sqrt sol = new Sqrt();
        long n = 17;
        long result = sol.floorSqrt(n);
        System.out.println("The floor square root of " + n + " is: " + result);
    }
}
