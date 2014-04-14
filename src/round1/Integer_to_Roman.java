package round1;

public class Integer_to_Roman {

	public static void main(String[] args) {
		Integer_to_Roman i = new Integer_to_Roman();
		System.out.println(i.intToRoman(3444));
	}

	public String intToRoman(int num) {
		String[] rep = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
				"V", "IV", "I" };
		int[] number = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; num != 0; i++) {
			while (number[i] <= num) {
				sb.append(rep[i]);
				num -= number[i];
			}
		}
		return sb.toString();
	}
}
