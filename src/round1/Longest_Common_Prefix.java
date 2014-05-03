package round1;

public class Longest_Common_Prefix {

	public static void main(String[] args) {
		Longest_Common_Prefix l = new Longest_Common_Prefix();
		System.out.println(l.longestCommonPrefix(new String[] { "aa", "aaa","ab" }));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = strs[0].length(); i < len; i++) {
			char ch = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++)
				if (i >= strs[j].length() || ch != strs[j].charAt(i))
					return sb.toString();
			sb.append(ch);
		}
		return sb.toString();
	}
}
