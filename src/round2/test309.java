package round2;

public class test309 {
    public static void main(String[] args) {
        System.out.println(new test309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[] sells = new int[len];
        int[] buys = new int[len];
        sells[0] = 0;
        buys[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            int delta = prices[i] - prices[i - 1];
            sells[i] = Math.max(buys[i - 1] + prices[i], sells[i - 1] + delta);
            buys[i] = i == 1 ? buys[i - 1] - delta :
                    Math.max(buys[i - 1] - delta, sells[i - 2] - prices[i]);
        }
        int max = 0;
        for (int profit : sells)
            max = Math.max(max, profit);
        return max;
    }
}
