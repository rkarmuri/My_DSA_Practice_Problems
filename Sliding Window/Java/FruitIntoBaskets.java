import java.util.HashMap;
import java.util.Map;
public class FruitIntoBaskets {
    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int r = 0, l = 0, maxLen = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(r < n){
          map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);
          if(map.size() > 2){
            map.put(fruits[l], map.get(fruits[l]) - 1);
            if(map.get(fruits[l]) == 0){
              map.remove(fruits[l]);
            }

            l++;
          }
          if(map.size() <= 2){
            maxLen = Math.max(maxLen, r - l + 1);
          }

          r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        FruitIntoBaskets solution = new FruitIntoBaskets();
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println("Total Fruits: " + solution.totalFruits(fruits)); // Output: 4
    }
}
