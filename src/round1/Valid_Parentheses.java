package round1;

import java.util.Stack;

public class Valid_Parentheses {
	public static void main(String[] args) {
		Valid_Parentheses v = new Valid_Parentheses();
		System.out.println(v.isValid("()[[]"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(')
				stack.push(ch);
			else if (stack.isEmpty())
				return false;
			else if (ch == '}' && stack.pop() != '{')
				return false;
			else if (ch == ']' && stack.pop() != '[')
				return false;
			else if (ch == ')' && stack.pop() != '(')
				return false;
		}
		return stack.isEmpty();
	}
}
