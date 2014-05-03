package round1;

public class Add_Binary {

	public static void main(String[] args) {
		Add_Binary a = new Add_Binary();
		System.out.println(a.addBinary("1", "111"));
	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			int temp = carry + a.charAt(i--) + b.charAt(j--) - '0' - '0';
			carry = temp / 2;
			sb.insert(0, temp % 2);
		}
		while (i >= 0) {
			int temp = carry + a.charAt(i--) - '0';
			carry = temp / 2;
			sb.insert(0, temp % 2);
		}
		while (j >= 0) {
			int temp = carry + b.charAt(j--) - '0';
			carry = temp / 2;
			sb.insert(0, temp % 2);
		}
		if (carry > 0)
			sb.insert(0, carry);
		return sb.toString();
	}
}
