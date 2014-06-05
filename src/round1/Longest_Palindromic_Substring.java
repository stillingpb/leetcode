package round1;

public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		String s = "aabac";
		Longest_Palindromic_Substring l = new Longest_Palindromic_Substring();
		System.out.println(l.longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		int begin = 0;
		int end = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			int j = 0;
			for (; j <= i && i + j < len; j++)
				if (s.charAt(i - j) != s.charAt(i + j))
					break;
			if (2 * j - 1 > end - begin) {
				begin = i - j + 1;
				end = i + j - 1;
			}
			for (j = 0; j <= i && i + j + 1 < len; j++)
				if (s.charAt(i - j) != s.charAt(i + j + 1))
					break;
			if (2 * j > end - begin) {
				begin = i - j + 1;
				end = i + j;
			}
		}
		return s.substring(begin, end + 1);
	}
}
