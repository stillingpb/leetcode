package round1;

public class Decode_Ways {

	public static void main(String[] args) {
		Decode_Ways d = new Decode_Ways();
		System.out.println(d.numDecodings("27"));
	}

	public int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		if (s.length() == 1)
			return 1;
		char pre = s.charAt(0);
		char cur = s.charAt(1);
		int f1 = 1;
		int f2;
		if (cur == '0') {
			if (pre != '1' && pre != '2')
				return 0;
			f2 = 1;
		} else
			f2 = f1 + (isValid(pre, cur) ? 1 : 0);

		for (int i = 2, len = s.length(); i < len; i++) {
			pre = s.charAt(i - 1);
			cur = s.charAt(i);
			int temp = 0;
			if (cur == '0') {
				if (pre != '1' && pre != '2')
					return 0;
				temp = f1;
			} else
				temp = f2 + (isValid(pre, cur) ? f1 : 0);
			f1 = f2;
			f2 = temp;
		}
		return f2;
	}

	private boolean isValid(char a, char b) {
		if (a == '0' || a > '2')
			return false;
		if (a == '2' && b > '6')
			return false;
		return true;
	}
}
