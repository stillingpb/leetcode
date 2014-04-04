package round1;

import java.util.Stack;

public class Valid_Paraentheses {
	public static void main(String[] args) {
		boolean b = new Valid_Paraentheses().isValid("{[]}}");
		System.out.println(b);
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0, len = s.length(); i < len; i++) {
			char c = s.charAt(i);
			boolean boo = true;
			switch (c) {
			case '{':
			case '(':
			case '[':
				stack.push(c);
				break;
			case '}':
				if (stack.isEmpty())
					return false;
				boo = stack.pop() == '{';
				break;
			case ']':
				if (stack.isEmpty())
					return false;
				boo = stack.pop() == '[';
				break;
			case ')':
				if (stack.isEmpty())
					return false;
				boo = stack.pop() == '(';
				break;
			}
			if (!boo)
				return false;
		}
		return stack.isEmpty();
	}

}
