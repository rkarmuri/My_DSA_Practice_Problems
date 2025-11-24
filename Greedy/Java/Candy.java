public class Candy {

    // Intution: Use left and right passes to ensure both conditions are met
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int candyBruteForce(int[] ratings){
        int n = ratings.length;
        int[] candies = new int[n];

        // Each child gets at least one candy
        for(int i = 0; i < n; i++){
            candies[i] = 1;
        }

        // Left to right
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        // Right to left
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int sum = 0;
        for(int i : candies){
            sum += i;
        }
        return sum;
    }

    // Optimized Approach
    // Intution: Count peaks and valleys in a single pass
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int candyOptimized(int[] ratings){
        int n = ratings.length;
        int sum = 1, i = 1; // Start with 1 candy for the first child

        // Each child gets at least one candy
        while(i < n){
            if(ratings[i] == ratings[i-1]){ // Equal ratings or slant slopes
                sum += 1;
                i++;
                continue; // Move to the next child
            }

            int peak = 1; // Start with the first child in the increasing sequence
            
            // Peak increases as the slope goes up and adds to the sum
            while(i < n && ratings[i] > ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }

            int down = 1; // Start with the first child in the decreasing sequence
            // Down increases as the slope goes down and adds to the sum
            while(i < n && ratings[i] < ratings[i-1]){
                sum += down;
                down++;
                i++;
            }
            
            // If the downward slope is longer than the peak, adjust the sum
            if(down > peak){
                sum += down - peak;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candyBruteForce(ratings)); // Output: 5
        System.out.println(candyOptimized(ratings)); // Output: 5
    }
}
