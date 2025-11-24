import java.util.ArrayList;
import java.util.List;
public class AsteroidCollision {
    private static int[] asteroidCollision(int[] asteroids){
        // Time Complexity: O(n), Space Complexity: O(n)
        int n = asteroids.length;
        List<Integer> stack = new ArrayList<>();

        for(int i = 0; i < n; i++){
            // If the asteroid is moving to the right, add it to the stack
            if(asteroids[i] > 0){
                stack.add(asteroids[i]);
            } else {
                // Compare with the top of the stack for collision
                while(!stack.isEmpty() && stack.get(stack.size() - 1) > 0 && stack.get(stack.size() - 1) < Math.abs(asteroids[i])){
                    stack.remove(stack.size() - 1);
                }
                if(!stack.isEmpty() && stack.get(stack.size() - 1) == Math.abs(asteroids[i])){
                    stack.remove(stack.size() - 1);
                } else if(stack.isEmpty() || stack.get(stack.size() - 1) < 0){
                    stack.add(asteroids[i]);
                }
            }
        }

        int[] ans = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++){
            ans[i] = stack.get(i);      
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5, -10, 8, -8, 3, 14};
        int[] result = asteroidCollision(asteroids);
        System.out.println("Remaining asteroids after collision:");
        for(int asteroid : result){
            System.out.print(asteroid + " ");
        }
    }
}
