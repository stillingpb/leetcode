package round1;

import java.util.ArrayList;
import java.util.Arrays;

public class Plus_One {

	public static void main(String[] args) {
		Plus_One p = new Plus_One();
		int dig[] = { 9 };
		dig = p.plusOne(dig);
		for(int i=0;i<dig.length;i++)
			System.out.print(dig[i]+" ");
	}

	public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; carry > 0 && i >= 0; i--) {
			int cur = digits[i];
			digits[i] = (cur + carry) % 10;
			carry = (cur + carry) / 10;
		}
		if (carry == 0)
			return digits;
		int[] ans = new int[digits.length + 1];
		ans[0] = carry;
		for (int i = 1; i < ans.length; i++)
			ans[i] = digits[i - 1];
		return ans;
	}
}
