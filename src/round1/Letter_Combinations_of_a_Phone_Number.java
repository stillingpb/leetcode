package round1;

import java.util.ArrayList;

public class Letter_Combinations_of_a_Phone_Number {

	public static void main(String[] args) {
		Letter_Combinations_of_a_Phone_Number l = new Letter_Combinations_of_a_Phone_Number();
		System.out.println(l.letterCombinations("243"));
	}

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> ans = new ArrayList<String>();
		letterCombinations(ans, digits, 0, "");
		return ans;
	}

	private static final String[] table = { " ",// 0
			"",// 1
			"abc",// 2
			"def",// 3
			"ghi",// 4
			"jkl",// 5
			"mno",// 6
			"pqrs",// 7
			"tuv",// 8
			"wxyz"// 9
	};

	private void letterCombinations(ArrayList<String> ans, String digits,
			int start, String str) {
		if (start >= digits.length()) {
			ans.add(str);
			return;
		}
		int index = digits.charAt(start) - '0';
		for (int i = 0, len = table[index].length(); i < len; i++)
			letterCombinations(ans, digits, start + 1,
					str + table[index].charAt(i));
	}

}
