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
        int maxLen = 0;
        int start = -1;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                    continue;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    maxLen = Math.max(maxLen, i - start);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
