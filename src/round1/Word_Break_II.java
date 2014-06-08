package round1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Word_Break_II {

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] tmp = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
				"aaaaaaaaaa" };
		Set<String> dict = new HashSet<String>();
		for (String str : tmp)
			dict.add(str);
		List<String> ans = new Word_Break_II().wordBreak(s, dict);
		for (String str : ans)
			System.out.println(str);
	}

	public List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<Integer>[] pos = new ArrayList[s.length()];
		ArrayList<String>[] posStr = new ArrayList[s.length()];
		boolean reached = false;
		int sLen = s.length();
		for (String str : dict) {
			int i = -1;
			int strLen = str.length();
			while ((i = s.indexOf(str, i + 1)) != -1) {
				if (i + strLen == sLen)
					reached = true;
				if (pos[i] == null) {
					pos[i] = new ArrayList<Integer>();
					posStr[i] = new ArrayList<String>();
				}
				pos[i].add(i + strLen);
				posStr[i].add(str);
			}
		}
		List<String> ans = new ArrayList<String>();
		if (reached)
			traverse(ans, s, pos, posStr, 0, new Stack<String>());
		return ans;
	}

	private void traverse(List<String> ans, String s, ArrayList<Integer>[] pos, ArrayList<String>[] posStr,
			int begin, Stack<String> stack) {
		if (begin == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (String sub : stack)
				sb.append(sub).append(' ');
			sb.deleteCharAt(sb.length() - 1);
			ans.add(sb.toString());
			return;
		}
		if (pos[begin] == null)
			return;
		for (int i = 0, size = pos[begin].size(); i < size; i++) {
			stack.push(posStr[begin].get(i));
			traverse(ans, s, pos, posStr, pos[begin].get(i), stack);
			stack.pop();
		}
	}
}