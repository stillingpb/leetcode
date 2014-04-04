package round1;

/**
 * wrong answer
 * @author pb
 *
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {
	public static void main(String[] args) {
//		System.out.println(new Best_Time_to_Buy_and_Sell_Stock_III()
//				.maxProfit(new int[] { 2, 2, 3, 25, 1, 6, 3, 2, 7 }));
	}

//	public int maxProfit(int[] prices) {
//		int firstProfit = maxProfit(prices, 0, prices.length);
//
//		int leftProfit = maxProfit(prices, 0, left);
//		int rightProfit = maxProfit(prices, right + 1, prices.length - right
//				- 1);
//		int secondProfit = leftProfit > rightProfit ? leftProfit : rightProfit;
//		return firstProfit + secondProfit;
//	}
//
//	private int left;
//	private int right;
//
//	private int maxProfit(int[] prices, int offset, int len) {
//		if (len <= 1)
//			return 0;
//		int maxProfit = Integer.MIN_VALUE;
//		int buyPrice = prices[offset];
//		int leftTmp = offset;
//
//		for (int i = offset + 1; i < offset + len; i++) {
//			int profit = prices[i] - buyPrice;
//			if (profit >= maxProfit) {
//				maxProfit = profit;
//				left = leftTmp;
//				right = i;
//			}
//			if (buyPrice >= prices[i]) {
//				buyPrice = prices[i];
//				leftTmp = i;
//			}
//		}
//		return maxProfit > 0 ? maxProfit : 0;
//	}
}
