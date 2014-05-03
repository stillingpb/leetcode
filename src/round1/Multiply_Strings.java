package round1;

public class Multiply_Strings {

	public static void main(String[] args) {
		Multiply_Strings m = new Multiply_Strings();
		System.out.println(m.multiply("12", "23"));
	}

	public String multiply(String num1, String num2) {
		String ans = "0";
		String weight = "";
		for (int i = num2.length() - 1; i >= 0; i--) {
			String temp = multiply(num1, num2.charAt(i) - '0');
			ans = add(ans, temp + weight);
			weight += "0";
		}
		int i = 0;
		for (; i < ans.length() - 1; i++)
			if (ans.charAt(i) != '0')
				break;
		ans = ans.substring(i);
		return ans;
	}

	private String add(String num1, String num2) {
		StringBuilder ans = new StringBuilder();
		int len1 = num1.length();
		int len2 = num2.length();
		int i = 0;
		int carry = 0;
		while (i < len1 && i < len2) {
			int temp = carry + num1.charAt(len1 - i - 1) - '0'
					+ num2.charAt(len2 - i - 1) - '0';
			ans.insert(0, temp % 10);
			carry = temp / 10;
			i++;
		}
		while (i < len1) {
			int temp = carry + num1.charAt(len1 - i - 1) - '0';
			ans.insert(0, temp % 10);
			carry = temp / 10;
			i++;
		}
		while (i < len2) {
			int temp = carry + num2.charAt(len2 - i - 1) - '0';
			ans.insert(0, temp % 10);
			carry = temp / 10;
			i++;
		}
		if (carry != 0)
			ans.insert(0, carry);
		return ans.toString();
	}

	private String multiply(String num, int n) {
		int carry = 0;
		StringBuilder ans = new StringBuilder();
		for (int i = num.length() - 1; i >= 0; i--) {
			int temp = num.charAt(i) - '0';
			ans.insert(0, (carry + temp * n) % 10);
			carry = (carry + temp * n) / 10;
		}
		if (carry != 0)
			ans.insert(0, carry);
		return ans.toString();
	}
}
