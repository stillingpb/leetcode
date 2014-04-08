package round1;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		int len = new Longest_Substring_Without_Repeating_Characters()
				.lengthOfLongestSubstring("1asdfasdf");
		System.out.println(len);
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int maxLen = 0;
		int pi = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // <char,index>
		map.put(s.charAt(0), 0);

		for (int i = 1, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				maxLen = Math.max(maxLen, map.size());
				int index = map.get(ch) + 1;
				for (int j = pi; j < index; j++)
					map.remove(s.charAt(j));
				pi = index;
			}
			map.put(ch, i);
		}
		return Math.max(maxLen, map.size());
	}

}
