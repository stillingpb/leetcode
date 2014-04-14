package round1;

public class Valid_Number {

	public static void main(String[] args) {
		Valid_Number v = new Valid_Number();
		System.out.println(v.isNumber("abc"));
		System.out.println(v.isNumber("1 a"));
		System.out.println(v.isNumber("e"));
		System.out.println(v.isNumber("."));
		System.out.println(v.isNumber("6ee"));
		System.out.println(v.isNumber("+++"));
		System.out.println(v.isNumber("+"));
		System.out.println(v.isNumber("-."));
		System.out.println(v.isNumber("6e6.5"));

		System.out.println(v.isNumber("0"));
		System.out.println(v.isNumber("0.1"));
		System.out.println(v.isNumber(".1"));
		System.out.println(v.isNumber("1."));
		System.out.println(v.isNumber("2e10"));
		System.out.println(v.isNumber("-1."));
	}

	public boolean isNumber(String s) {
		s = s.trim();
		for (int i = 0, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			if (ch != '-' && ch != '+' && ch != 'e' && ch != '.'
					&& !(ch >= '0' && ch <= '9'))
				return false;
		}
		if (s.indexOf('e') != -1) {
			int i = s.indexOf('e');
			if (s.indexOf('e', i + 1) != -1)
				return false;
			return isNumber1(s.substring(0, i))
					&& isInt(s.substring(i + 1, s.length()));
		}
		return isNumber1(s);
	}

	private boolean isInt(String s) {
		boolean hasNum = false;
		for (int i = 0, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				hasNum = true;
				break;
			}
		}
		if (!hasNum)
			return false;
		if (s.lastIndexOf('+') > 0 || s.lastIndexOf('-') > 0
				|| s.indexOf('.') != -1)
			return false;
		return true;
	}

	private boolean isNumber1(String s) {
		boolean hasNum = false;
		for (int i = 0, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				hasNum = true;
				break;
			}
		}
		if (!hasNum)
			return false;
		if (s.lastIndexOf('+') > 0 || s.lastIndexOf('-') > 0)
			return false;
		int i = s.indexOf('.');
		if (i == -1) {
			return true;
		}
		if (s.indexOf('.', i + 1) != -1)
			return false;
		return true;
	}
}
