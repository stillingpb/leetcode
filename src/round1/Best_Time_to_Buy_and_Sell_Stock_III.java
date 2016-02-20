package round1;

/**
 * 可以延伸求在一个数组中，两个连续子串的最大和。
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_III b = new Best_Time_to_Buy_and_Sell_Stock_III();
        System.out.println(b.maxProfit(new int[]{6, 1, 3, 2, 5, 7}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int profit[] = new int[len];
        int minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit[i] = Math.max(profit[i - 1], prices[i] - minPrice);
        }
        int maxPrice = prices[len - 1];
        int maxProfit = profit[len - 1];
        for (int i = len - 2; i >= 0; i++) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(profit[i] + maxPrice - prices[i], maxProfit);
        }
        return maxProfit;
    }
}
