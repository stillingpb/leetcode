package round1;

public class Add_Binary {
	public static void main(String[] args) {
		System.out.println(new Add_Binary().addBinary("10", "0"));
	}

	public String addBinary(String a, String b) {
		StringBuilder ans = new StringBuilder();
		int lena = a.length();
		int lenb = b.length();
		int carry = 0;
		int i = 0;
		for (; i < lena && i < lenb; i++) {
			int inta = a.charAt(lena - i - 1) - '0';
			int intb = b.charAt(lenb - i - 1) - '0';
			ans.insert(0, (inta + intb + carry) % 2);
			carry = (inta + intb + carry) / 2;
		}
		while (i < lena) {
			int inta = a.charAt(lena - i - 1) - '0';
			ans.insert(0, (inta + carry) % 2);
			carry = (inta + carry) / 2;
			i++;
		}
		while (i < lenb) {
			int intb = b.charAt(lenb - i - 1) - '0';
			ans.insert(0, (intb + carry) % 2);
			carry = (intb + carry) / 2;
			i++;
		}
		if (carry != 0)
			ans.insert(0, carry);
		return ans.toString();
	}
}
