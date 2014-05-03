package round1;

public class Count_and_Say {

	public static void main(String[] args) {
		System.out.println(new Count_and_Say().countAndSay(5));
	}

	public String countAndSay(int n) {
		String cur = "1";
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			char ch = cur.charAt(0);
			for (int j = 1, len = cur.length(); j < len; j++) {
				if (ch == cur.charAt(j))
					count++;
				else {
					sb.append(count).append(ch);
					ch = cur.charAt(j);
					count = 1;
				}
			}
			sb.append(count).append(ch);
			cur = sb.toString();
		}
		return cur;
	}
}
