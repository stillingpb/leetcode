package round1;

import java.util.Stack;

public class Longest_Valid_Parentheses {

	public static void main(String[] args) {
		Longest_Valid_Parentheses l = new Longest_Valid_Parentheses();
		System.out.println(l.longestValidParentheses("(()())"));
		System.out.println(l.longestValidParentheses("(()(())"));
		System.out.println(l.longestValidParentheses(")()())"));
		System.out.println(l.longestValidParentheses("(()"));
		System.out.println(l.longestValidParentheses("()(()"));
	}

	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> matchLeft = new Stack<Integer>();
		Stack<Integer> matchRight = new Stack<Integer>();

		for (int i = 0, len = s.length(); i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (!stack.isEmpty()) {
				int left = stack.pop();
				int right = i;
				while (!matchLeft.isEmpty() && (left < matchLeft.peek() || matchRight.peek() + 1 == left)) {
					left = Math.min(left, matchLeft.pop());
					matchRight.pop();
				}
				matchLeft.push(left);
				matchRight.push(right);
			}
		}
		int longest = 0;
		while (!matchLeft.isEmpty()) {
			longest = Math.max(longest, matchRight.pop() - matchLeft.pop() + 1);
		}
		return longest;
	}
}
