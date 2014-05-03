package round1;

public class Best_Time_to_Buy_and_Sell_Stock_III {
	public static void main(String[] args) {
		Best_Time_to_Buy_and_Sell_Stock_III b = new Best_Time_to_Buy_and_Sell_Stock_III();
		System.out.println(b.maxProfit(new int[] { 6, 1, 3, 2, 5, 7 }));
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		int[] profit = new int[len];
		int minPrice = prices[0];
		for (int i = 1; i < len; i++) {
			if (minPrice > prices[i])
				minPrice = prices[i];
			profit[i] = Math.max(profit[i - 1], prices[i] - minPrice);
		}
		int maxProfit = profit[len - 1];
		int maxPrice = prices[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			if (maxPrice < prices[i])
				maxPrice = prices[i];
			maxProfit = Math.max(maxProfit, maxPrice - prices[i] + profit[i]);
		}
		return maxProfit;
	}
}
