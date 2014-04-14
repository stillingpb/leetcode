package round1;

public class String_to_Integer_atoi {

	public static void main(String[] args) {
		String_to_Integer_atoi s = new String_to_Integer_atoi();
		System.out.println(s.atoi("123"));
		System.out.println(s.atoi(" 123"));
		System.out.println(s.atoi(" "));
		System.out.println(s.atoi("+123"));
		System.out.println(s.atoi("  -0012a42"));
		System.out.println(s.atoi("" + Integer.MAX_VALUE + "000"));
	}

	public int atoi(String str) {
		if (str == null || "".equals(str.trim()))
			return 0;
		str = str.trim();
		boolean negtive = false;
		long num = 0;
		int i = 0, len = str.length();
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			i++;
			negtive = str.charAt(0) == '-';
		}
		while (i < len) {
			char ch = str.charAt(i++);
			if (ch < '0' || ch > '9')
				break;
			num = num * 10 + ch - '0';
		}
		if (num > Integer.MAX_VALUE)
			return negtive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		else
			return (int) (negtive ? -num : num);
	}
}
