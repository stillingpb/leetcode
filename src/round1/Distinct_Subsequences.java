package round1;

public class Distinct_Subsequences {

	public static void main(String[] args) {
		String S = "ccc";
		String T = "c";
		long begin = System.currentTimeMillis();
		System.out.println(new Distinct_Subsequences().numDistinct(S, T));
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

	public int numDistinct(String S, String T) {
		int lens = S.length();
		int lent = T.length();
		int dp[][] = new int[lent + 1][lens + 1];
		for (int j = 0; j <= lens; j++)
			dp[0][j] = 1;
		for (int i = 1; i <= lent; i++)
			for (int j = 1; j <= lens; j++) {
				dp[i][j] = dp[i][j - 1];
				if (T.charAt(i - 1) == S.charAt(j - 1))
					dp[i][j] += dp[i - 1][j - 1];
			}
		return dp[lent][lens];
	}
}
