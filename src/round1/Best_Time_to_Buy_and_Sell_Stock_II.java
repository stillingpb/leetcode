package round1;

public class Best_Time_to_Buy_and_Sell_Stock_II {
	public static void main(String[] args) {
		Best_Time_to_Buy_and_Sell_Stock_II b = new Best_Time_to_Buy_and_Sell_Stock_II();
		System.out.println(b.maxProfit(new int[] { 2, 1, 3, 7, 2, 4 }));
	}

	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int sumProfit = 0;
		for (int i = 1; i < prices.length; i++)
			if (prices[i - 1] < prices[i])
				sumProfit += prices[i] - prices[i - 1];
		return sumProfit;
	}
}
