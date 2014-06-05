package round1;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

	public static void main(String[] args) {
		String S = "bdab";
		String T = "ab";
		System.out.println(new Minimum_Window_Substring().minWindow(S, T));
	}

	public String minWindow(String S, String T) {
		Map<Character, Integer> oriMap = new HashMap<Character, Integer>();
		for (int i = 0, lenT = T.length(); i < lenT; i++) {
			char ch = T.charAt(i);
			Integer count = oriMap.get(ch);
			if (count != null)
				oriMap.put(ch, count + 1);
			else
				oriMap.put(ch, 1);
		}
		Map<Character, Integer> windowMap = new HashMap<Character, Integer>();
		int i = findWindow(S, T, oriMap, windowMap, 0);
		if (i == -1)
			return "";
		int minBegin = 0;
		int minEnd = S.length();
		for (int begin = 0, lenS = S.length(); begin < lenS;) {
			while (begin < lenS) {
				char ch = S.charAt(begin++);
				Integer oriCount = oriMap.get(ch);
				if (oriCount == null)
					continue;
				int windowCount = windowMap.get(ch);
				windowMap.put(ch, windowCount - 1);
				if (oriCount == windowCount)
					break;
			}
			if (begin - 1 < lenS && i - begin + 1 < minEnd - minBegin) {
				minBegin = begin - 1;
				minEnd = i;
			}
			i = findWindow(S, T, oriMap, windowMap, i + 1);
			if (i == -1)
				break;
		}
		return S.substring(minBegin, minEnd + 1);
	}

	private int findWindow(String S, String T, Map<Character, Integer> oriMap,
			Map<Character, Integer> windowMap, int i) {
		for (int lenS = S.length(); i < lenS; i++) {
			char ch = S.charAt(i);
			if (!oriMap.containsKey(ch))
				continue;
			Integer count = windowMap.get(ch);
			if (count != null)
				windowMap.put(ch, count + 1);
			else
				windowMap.put(ch, 1);
			if (windowMap.get(ch) < oriMap.get(ch))
				continue;
			boolean large = true;
			for (Character c : oriMap.keySet()) {
				Integer windowCount = windowMap.get(c);
				if (windowCount == null || windowCount < oriMap.get(c)) {
					large = false;
					break;
				}
			}
			if (large)
				return i;
		}
		return -1;
	}
}
