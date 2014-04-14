package round1;

import java.util.HashMap;

public class Roman_to_Integer {

	public static void main(String[] args) {
		Roman_to_Integer r = new Roman_to_Integer();
		System.out.println(r.romanToInt2("MMMCDXLIV"));
	}

	public int romanToInt(String s) {
		String[] rep = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
				"V", "IV", "I" };
		int[] number = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		HashMap<String, Integer> map = new HashMap<String, Integer>(); // <rep,number>
		for (int i = 0; i < rep.length; i++)
			map.put(rep[i], number[i]);

		int ans = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			String str = ch + "";
			if ((ch == 'C' || ch == 'X' || ch == 'I') && i < len - 1) // CM,CD,XC,XL,IX,IV
				if (map.containsKey(str + s.charAt(i + 1)))
					str += s.charAt(++i);
			ans += map.get(str);
		}
		return ans;
	}

	public int romanToInt2(String s) {
		char[] rep = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int[] number = { 1000, 500, 100, 50, 10, 5, 1 };
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < rep.length; i++)
			map.put(rep[i], number[i]);

		int len = s.length();
		int ans = map.get(s.charAt(len - 1));
		for (int i = len - 2; i >= 0; i--) {
			char ch = s.charAt(i);
			char nextCh = s.charAt(i + 1);
			if (map.get(ch) < map.get(nextCh))
				ans -= map.get(ch);
			else
				ans += map.get(ch);
		}
		return ans;
	}
}
