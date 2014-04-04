package round1;


public class Best_Time_to_Buy_and_Sell_Stock {
	public static void main(String[] args) {
		System.out.println(new Best_Time_to_Buy_and_Sell_Stock()
				.maxProfit(new int[] {  2,2,3,25, 1, 6, 3 }));
	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;
		int maxProfit = Integer.MIN_VALUE;
		int buyPrice = prices[0];

		for (int i = 1; i < len; i++) {
			int profit = prices[i] - buyPrice;
			if (profit > maxProfit)
				maxProfit = profit;
			if (buyPrice > prices[i])
				buyPrice = prices[i];
		}
		return maxProfit > 0 ? maxProfit : 0;
	}
}
