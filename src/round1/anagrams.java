package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class anagrams {
	public static void main(String[] args) {
		anagrams a = new anagrams();
		System.out.println(a.anagrams(new String[] { "tea", "and", "ate",
				"eat", "den" }));
	}

	public ArrayList<String> anagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String dummy = new String(chs);
			List<String> anagrams = map.get(dummy);
			if (anagrams == null) {
				anagrams = new ArrayList<String>();
				map.put(dummy, anagrams);
			}
			anagrams.add(str);
		}
		ArrayList<String> ans = new ArrayList<String>();
		for (List<String> anagrams : map.values()) {
			if (anagrams.size() > 1)
				ans.addAll(anagrams);
		}
		return ans;
	}
}
