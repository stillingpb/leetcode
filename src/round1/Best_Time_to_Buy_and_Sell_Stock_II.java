package round1;

import java.util.ArrayList;

public class Best_Time_to_Buy_and_Sell_Stock_II {
	public static void main(String[] args) {
		System.out.println(new Best_Time_to_Buy_and_Sell_Stock_II()
				.maxProfit(new int[] { 2}));
	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1)
			return 0;
		int sumProfit = 0;
		for (int i = 1; i < prices.length; i++)
			if (prices[i - 1] < prices[i])
				sumProfit += prices[i] - prices[i - 1];
		return sumProfit;
	}
}
