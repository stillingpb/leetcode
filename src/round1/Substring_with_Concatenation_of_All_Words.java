package round1;

import java.util.ArrayList;
import java.util.HashMap;

public class Substring_with_Concatenation_of_All_Words {

	public static void main(String[] args) {
		Substring_with_Concatenation_of_All_Words s = new Substring_with_Concatenation_of_All_Words();
		String S = "aabacaa";
		String[] L = new String[] { "ab", "ac" };
		ArrayList<Integer> start = s.findSubstring(S, L);
		System.out.println(start);
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();// <str,count>
		for (String str : L) {
			Integer count = map.get(str);
			if (count != null)
				map.put(str, count + 1);
			else
				map.put(str, 1);
		}
		int wordLen = L[0].length();
		int windowLen = wordLen * L.length;

		HashMap<String, Integer> temp = new HashMap<String, Integer>();// <str,count>
		for (int i = 0, strLen = S.length(); i <= strLen - windowLen; i++) {
			temp.clear();
			int j = 0;
			for (; j < L.length; j++) {
				String sub = S
						.substring(i + j * wordLen, i + (j + 1) * wordLen);
				if (!map.containsKey(sub)) {
					break;
				} else if (temp.containsKey(sub)) {
					temp.put(sub, temp.get(sub) + 1);
				} else
					temp.put(sub, 1);
			}
			if (j == L.length && map.equals(temp))
				ans.add(i);
		}
		return ans;
	}
}
