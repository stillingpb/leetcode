package round1;

public class Regular_Expression_Matching {
	public static void main(String[] args) {
		Regular_Expression_Matching r = new Regular_Expression_Matching();
//		System.out.println(r.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));
		System.out.println(r.isMatch("aaa", "ab*ac*a"));
		System.out.println(r.isMatch("aaa", "aa"));
		System.out.println(r.isMatch("aa", "a*"));
		System.out.println(r.isMatch("ab", ".*"));
		System.out.println(r.isMatch("aab", "c*a*b"));
		System.out.println(r.isMatch("ccaabb", ".*aab*"));
	}

	public boolean isMatch(String s, String p) {
		int lens = s.length(), lenp = p.length();
		boolean dp[][] = new boolean[lenp + 1][lens + 1];
		dp[0][0] = true;
		for (int i = 1; i <= lenp; i++) {
			if (p.charAt(i - 1) == '*') {
				for (int j = 0; j <= lens; j++)
					if (dp[i - 2][j] == true)
						dp[i][j] = true;
				char ch = p.charAt(i - 2);
				if (ch == '.') {
					int k = 0;
					for (; k <= lens; k++)
						if (dp[i - 1][k])
							break;
					for (int j = k; j <= lens; j++)
						dp[i][j] = true;
				} else {
					int k = 0;
					while (true) {
						for (; k <= lens; k++)
							if (dp[i - 1][k])
								break;
						if (k > lens)
							break;
						dp[i][k] = true;
						for (int j = k + 1; j <= lens; j++) {
							if (s.charAt(j - 2) != s.charAt(j - 1))
								break;
							dp[i][j] = true;
						}
						k++;
					}
				}
			} else if (p.charAt(i - 1) == '.') {
				for (int j = 1; j <= lens; j++)
					dp[i][j] = dp[i - 1][j - 1];
			} else {
				for (int j = 1; j <= lens; j++)
					dp[i][j] = dp[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
			}
		}

		return dp[lenp][lens];
	}
}
