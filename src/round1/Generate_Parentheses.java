package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Generate_Parentheses {

	public static void main(String[] args) {
		Generate_Parentheses g = new Generate_Parentheses();
		System.out.println(g.generateParenthesis(3));
	}

	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> ans = new ArrayList<String>();
		if (n == 0)
			return ans;
		generateParenthesis(ans, new char[n * 2], 0, 0, n);
		return ans;
	}

	private void generateParenthesis(ArrayList<String> ans, char ch[],
			int left, int right, int n) {
		if (left == n) {
			Arrays.fill(ch, left + right, n << 1, ')');
			ans.add(new String(ch));
			return;
		}
		ch[left + right] = '(';
		generateParenthesis(ans, ch, left + 1, right, n);
		if (left > right) {
			ch[left + right] = ')';
			generateParenthesis(ans, ch, left, right + 1, n);
		}
	}
}
