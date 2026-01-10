import java.util.List;

public class OfferPizzaOrders {
    // Discount Offer: Customer gets a discount if they order pizza for 2 consecutive days
    // Coupon Offer: Customer uses a coupon to get 2 pizzas for the price of 1 on a single day
    // We use DP to check if any of these offers can be availed
    public static int minCost(int[] price) {
        int n = price.length;
        int INF = Integer.MAX_VALUE / 2; // To prevent overflow

        int[][] dp = new int[n + 2][2]; // dp[i][0]: min cost till day i without coupon, dp[i][1]: with coupon
        // Initialize dp array
        for (int i = 0; i <= n + 1; i++) {
            dp[i][0] = dp[i][1] = INF;
        }

        dp[0][0] = 0; // No cost on day 0 without coupon

        for (int i = 0; i < n; i++) {

            // Option 1: Buy alone
            dp[i + 1][0] = Math.min(dp[i + 1][0],
                    Math.min(dp[i][0], dp[i][1]) + price[i]);

            // Option 2: Coupon (two consecutive days)
            if (i > 0) {
                int couponCost = (price[i - 1] + price[i]) / 2;
                dp[i + 1][1] = Math.min(dp[i + 1][1],
                        dp[i][0] + couponCost);
            }

            // Option 3: Discount (two pizzas same day)
            if (i + 1 < n) {
                int discountCost = (price[i] + price[i + 1]) * 80 / 100;
                dp[i + 2][0] = Math.min(dp[i + 2][0],
                        Math.min(dp[i][0], dp[i][1]) + discountCost);
            }
        }

        return Math.min(dp[n][0], dp[n][1]);

    }

    public static void main(String[] args) {
        int[] price = {100, 200, 300, 400, 500};
        System.out.println("Minimum Cost: " + minCost(price)); // Output: Minimum Cost
    }

}

