package no_submit;

import java.util.ArrayList;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		Palindrome_Partitioning p = new Palindrome_Partitioning();
		System.out.println(p.partition(""));
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		if (s == null || "".equals(s))
			return ans;
		ArrayList<String> parti = new ArrayList<String>();
		partition(ans, parti, s, 0, s.length());
		return ans;
	}

	private void partition(ArrayList<ArrayList<String>> ans,
			ArrayList<String> parti, String s, int begin, int len) {
		if (len == 0) {
			ArrayList<String> list = new ArrayList<String>(parti);
			ans.add(list);
			return;
		}
		for (int i = 1; i <= len; i++) {
			String sub = s.substring(begin, begin + i);
			if (!isPalindrome(sub))
				continue;
			parti.add(sub);
			partition(ans, parti, s, begin + i, len - i);
			parti.remove(parti.size() - 1);
		}
	}

	private boolean isPalindrome(String str) {
		for (int i = 0, len = str.length(); i < len / 2; i++)
			if (str.charAt(i) != str.charAt(len - i - 1))
				return false;
		return true;
	}
}
