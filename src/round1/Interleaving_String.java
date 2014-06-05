package round1;

public class Interleaving_String {

	public static void main(String[] args) {
		Interleaving_String i = new Interleaving_String();
		System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out
				.println(i
						.isInterleave(
								"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
								"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
								"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 + len2 != s3.length())
			return false;
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;
		for (int i = 0; i < len1; i++) {
			if (dp[i][0] == false)
				break;
			dp[i + 1][0] = s1.charAt(i) == s3.charAt(i);
		}
		for (int i = 0; i < len2; i++) {
			if (dp[0][i] == false)
				break;
			dp[0][i + 1] = s2.charAt(i) == s3.charAt(i);
		}
		for (int i = 0; i < len1; i++)
			for (int j = 0; j < len2; j++)
				dp[i + 1][j + 1] = dp[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1) || dp[i + 1][j]
						&& s2.charAt(j) == s3.charAt(i + j + 1);
		return dp[len1][len2];
	}
}
