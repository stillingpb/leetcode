package round1;

public class Wildcard_Matching {
	public static void main(String[] args) {
		Wildcard_Matching w = new Wildcard_Matching();
		System.out.println(w.isMatch("a", "*a*"));
		System.out.println(w.isMatch("aa", "a"));
		System.out.println(w.isMatch("aa", "aa"));
		System.out.println(w.isMatch("aaa", "aa"));
		System.out.println(w.isMatch("aa", "*"));
		System.out.println(w.isMatch("aa", "a*"));
		System.out.println(w.isMatch("ab", "?*"));
		System.out.println(w.isMatch("aab", "c*a*b"));
	}

	public boolean isMatch(String s, String p) {
		int lens = s.length(), lenp = p.length();
		int len =0;
        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) != '*') 
                len++;
		if(lens<len)
			return false;
		boolean[] dp = new boolean[lens + 1];
		dp[0] = true;
		for (int i = 1; i <= lenp; i++) {
			if (p.charAt(i - 1) == '*') {
				int k = 0;
				for (; k <= lens; k++)
					if (dp[k])
						break;
				for (int j = k; j <= lens; j++)
					dp[j] = true;
			} else if (p.charAt(i - 1) == '?') {
				for (int j = lens; j > 0; j--)
					dp[j] = dp[j - 1];
			} else {
				for (int j = lens; j > 0; j--)
					dp[j] = dp[j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
			}
			dp[0] = dp[0] && p.charAt(i - 1) == '*';
		}
		return dp[lens];
	}
}
