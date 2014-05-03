package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words {

	public static void main(String[] args) {
		Substring_with_Concatenation_of_All_Words s = new Substring_with_Concatenation_of_All_Words();
		String S = "barfoothefoobarman";
		String[] L = { "foo", "bar" };
		System.out.println(s.findSubstring(S, L));
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();// <str,count>
		for (String str : L) {
			Integer count = map.get(str);
			if (count == null)
				map.put(str, 1);
			else
				map.put(str, count + 1);
		}
		int wordLen = L[0].length();
		int windowLen = wordLen * L.length;
		for (int i = 0, strLen = S.length(); i < strLen - windowLen; i++) {
			HashMap<String, Integer> temp = new HashMap<String, Integer>(); // <str,count>
			boolean skip = false;
			for (int j = i; j < i + windowLen; j += wordLen) {
				String sub = S.substring(j, j + wordLen);
				Integer oriCount = map.get(sub);
				Integer count = temp.get(sub);
				if (oriCount == null || (count != null && oriCount <= count)) {
					skip = true;
					break;
				}
				if (count == null)
					temp.put(sub, 1);
				else
					temp.put(sub, count + 1);
			}
			if (!skip)
				ans.add(i);
		}

		return ans;
	}
}
