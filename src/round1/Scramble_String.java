package round1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Scramble_String {
	public static void main(String[] args) {
		Scramble_String s = new Scramble_String();
		System.out.println(s.isScramble("abc", "bca"));
		System.out.println(s.isScramble("great", "rgeat"));
		System.out.println(s.isScramble("great", "eatgr"));
		System.out.println(s.isScramble("eatr", "reat"));
		System.out.println(s.isScramble("abcd", "bdac"));
		System.out.println(s.isScramble("abab", "bbaa"));
		System.out.println(s.isScramble("abcd", "cabd"));
		System.out.println(s.isScramble("ccabcbabcbabbbbcbb", "bbbbabccccbbbabcba"));
		System.out.println(s.isScramble("great", "terag"));
		System.out.println(s.isScramble("cacbcccbcbaccbabbc", "ccbbbcbbbacaaccccc"));
		System.out.println(s.isScramble("tqxpxeknttgwoppemjkivrulaflayn", "afaylnlurvikjmeppowgttnkexpxqt"));
	}

	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int len = s1.length();
		boolean dp[][][] = new boolean[len][len][len + 1];
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
		for (int l = 2; l <= len; l++)
			for (int i = 0; i <= len - l; i++)
				for (int j = 0; j <= len - l; j++)
					for (int p = 1; p < l; p++)
						if ((dp[i][j][p] && dp[i + p][j + p][l - p])
								|| (dp[i][j + l - p][p] && dp[i + p][j][l - p])) {
							dp[i][j][l] = true;
							break;
						}
		return dp[0][0][len];
	}


	// public boolean isScramble(String s1, String s2) {
	// if (s1.equals(s2))
	// return true;
	// int len = s1.length();
	// int i = 0;
	// for (; i < len; i++)
	// if (s1.charAt(i) != s2.charAt(len - i - 1))
	// break;
	// if (i == len)
	// return true;
	//
	// for (int j = 0; j < len; j++) {
	// if (s1.charAt(0) == s2.charAt(j)) {
	// if (isScramble(s1.substring(1, len - j), s2.substring(j + 1, len))
	// && isScramble(s1.substring(len - j, len), s2.substring(0, j))
	// || isScramble(s1.substring(1, j + 1), s2.substring(0, j))
	// && isScramble(s1.substring(j + 1, len), s2.substring(j + 1, len)))
	// return true;
	// break;
	// }
	// if (s2.charAt(0) == s1.charAt(j)) {
	// if (isScramble(s2.substring(1, len - j), s1.substring(j + 1, len))
	// && isScramble(s2.substring(len - j, len), s1.substring(0, j))
	// || isScramble(s2.substring(1, j + 1), s1.substring(0, j))
	// && isScramble(s2.substring(j + 1, len), s1.substring(j + 1, len)))
	// return true;
	// break;
	// }
	//
	// if (s1.charAt(0) == s2.charAt(len - j - 1)) {
	// if (isScramble(s1.substring(1, j + 1), s2.substring(len - j, len))
	// && isScramble(s1.substring(j + 1, len), s2.substring(0, len - j - 1))
	// || isScramble(s1.substring(1, len - j), s2.substring(0, len - j - 1))
	// && isScramble(s1.substring(len - j, len), s2.substring(len - j, len)))
	// return true;
	// break;
	// }
	// if (s2.charAt(0) == s1.charAt(len - j - 1)) {
	// if (isScramble(s2.substring(1, j + 1), s1.substring(len - j, len))
	// && isScramble(s2.substring(j + 1, len), s1.substring(0, len - j - 1))
	// || isScramble(s2.substring(1, len - j), s1.substring(0, len - j - 1))
	// && isScramble(s2.substring(len - j, len), s1.substring(len - j, len)))
	// return true;
	// break;
	// }
	//
	// }
	// return false;
	// }
}
