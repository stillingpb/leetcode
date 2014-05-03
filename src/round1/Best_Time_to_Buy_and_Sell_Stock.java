package round1;

public class Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		Best_Time_to_Buy_and_Sell_Stock b = new Best_Time_to_Buy_and_Sell_Stock();
		System.out.println(b.maxProfit(new int[] { 2,1}));
	}

	public int maxProfit(int[] prices) {
		int buyPrice = Integer.MAX_VALUE;
		int gain = 0;
		for (int i = 0; i < prices.length; i++)
			if (buyPrice > prices[i])
				buyPrice = prices[i];
			else
				gain = Math.max(gain, prices[i] - buyPrice);
		return gain;
	}
}
