package round1;

import java.util.ArrayList;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		Palindrome_Partitioning p = new Palindrome_Partitioning();
		System.out.println(p.partition("aab"));
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		if (s == null || "".equals(s))
			return ans;
		ArrayList<String> sub = new ArrayList<String>();
		partition(ans, sub, s, 0, s.length());
		return ans;
	}

	private void partition(ArrayList<ArrayList<String>> ans,
			ArrayList<String> sub, String s, int begin, int len) {
		if (len == 0) {
			ArrayList<String> list = new ArrayList<String>(sub);
			ans.add(list);
			return;
		}
		for (int i = 1; i <= len; i++) {
			String str = s.substring(begin, begin + i);
			if (!isPalindrome(str))
				continue;
			sub.add(str);
			partition(ans, sub, s, begin + i, len - i);
			sub.remove(sub.size() - 1);
		}
	}

	private boolean isPalindrome(String str) {
		int len = str.length();
		for (int i = 0, l = len / 2; i < l; i++)
			if (str.charAt(i) != str.charAt(len - i - 1))
				return false;
		return true;
	}

}
