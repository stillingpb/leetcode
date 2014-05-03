package round1;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		Longest_Substring_Without_Repeating_Characters l = new Longest_Substring_Without_Repeating_Characters();
		System.out
				.println(l
						.lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
	}

	public int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				int index = map.get(ch);
				int size = map.size();
				int repeatLen = size + index - i + 1;
				for (int j = 0; j < repeatLen; j++)
					map.remove(s.charAt(index - j));
				maxLen = Math.max(maxLen, size);
			}
			map.put(ch, i);
		}
		return Math.max(maxLen, map.size());
	}
}
