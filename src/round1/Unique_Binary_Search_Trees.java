package round1;

public class Unique_Binary_Search_Trees {

	public static void main(String[] args) {
		Unique_Binary_Search_Trees u = new Unique_Binary_Search_Trees();
		System.out.println(u.numTrees(0));
	}

	public int numTrees(int n) {
		if (n == 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < i; j++)
				dp[i] += dp[j] * dp[i - j - 1];
		return dp[n];
	}
}
