package round1;

import java.util.ArrayList;

public class Multiply_Strings2 {
	public static void main(String[] args) {
		Multiply_Strings2 m = new Multiply_Strings2();
		System.out.println(m.multiplyDigit(9, m.toList("999"), 1));
		System.out.println(m.add(m.toList("99"), m.toList("999")));
		String ans = new Multiply_Strings2().multiply("10", "0");
		System.out.println(ans);
	}

	public String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2))
			return "0";
		return multiply(toList(num1), toList(num2));
	}

	private String multiply(ArrayList<Integer> num1, ArrayList<Integer> num2) {
		ArrayList<Integer> sum = new ArrayList<Integer>();
		int weight = 0;
		for (Integer digit : num1) {
			ArrayList<Integer> temp = multiplyDigit(digit, num2, weight++);
			sum = add(temp, sum);
		}
		return toString(sum);
	}

	private String toString(ArrayList<Integer> sum) {
		StringBuilder sb = new StringBuilder();
		for (int i = sum.size() - 1; i >= 0; i--)
			sb.append(sum.get(i));
		return sb.toString();
	}

	private ArrayList<Integer> add(ArrayList<Integer> num1,
			ArrayList<Integer> num2) {
		ArrayList<Integer> sum = new ArrayList<Integer>();
		int len1 = num1.size();
		int len2 = num2.size();
		int carry = 0;
		int i = 0;
		for (; i < len1 && i < len2; i++) {
			sum.add((num1.get(i) + num2.get(i) + carry) % 10);
			carry = (num1.get(i) + num2.get(i) + carry) / 10;
		}
		while (i < len1) {
			sum.add((num1.get(i) + carry) % 10);
			carry = (num1.get(i) + carry) / 10;
			i++;
		}
		while (i < len2) {
			sum.add((num2.get(i) + carry) % 10);
			carry = (num2.get(i) + carry) / 10;
			i++;
		}
		if (carry != 0)
			sum.add(carry);
		return sum;
	}

	private ArrayList<Integer> multiplyDigit(Integer digit,
			ArrayList<Integer> num, int weight) {
		ArrayList<Integer> mul = new ArrayList<Integer>();
		int carry = 0;
		for (int i = 0, len = num.size(); i < len; i++) {
			mul.add((digit * num.get(i) + carry) % 10);
			carry = (digit * num.get(i) + carry) / 10;
		}
		while (carry != 0) {
			mul.add(carry % 10);
			carry = carry / 10;
		}
		for (int i = 0; i < weight; i++)
			mul.add(0, 0);
		return mul;
	}

	private ArrayList<Integer> toList(String num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = num.length() - 1; i >= 0; i--)
			list.add(num.charAt(i) - '0');
		return list;
	}

}
