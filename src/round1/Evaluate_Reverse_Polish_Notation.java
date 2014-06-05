package round1;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		System.out.println(new Evaluate_Reverse_Polish_Notation()
				.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if ("+".equals(tokens[i])) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a + b);
			} else if ("-".equals(tokens[i])) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			} else if ("*".equals(tokens[i])) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a * b);
			} else if ("/".equals(tokens[i])) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}
}
