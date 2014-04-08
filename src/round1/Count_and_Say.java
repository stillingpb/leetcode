package round1;

public class Count_and_Say {

	public static void main(String[] args) {
		Count_and_Say cs = new Count_and_Say();
		String str = cs.countAndSay(1);
		System.out.println(str);
	}

	public String countAndSay(int n) {
		String cur = "1";
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			char curChar = cur.charAt(0);
			int count = 1;
			for (int j = 1, len = cur.length(); j < len; j++) {
				char ch = cur.charAt(j);
				if (curChar == ch) {
					count++;
				} else {
					sb.append(count).append(curChar);
					curChar = ch;
					count = 1;
				}
			}
			sb.append(count).append(curChar);
			cur = sb.toString();
		}
		return cur;
	}
}
