package round1;

import java.util.Stack;

public class Simplify_Path {

	public static void main(String[] args) {
		Simplify_Path s = new Simplify_Path();
		System.out.println(s.simplifyPath("/home/"));
		System.out.println(s.simplifyPath("/a/./b/../../c/"));
		System.out.println(s.simplifyPath("/../"));
		System.out.println(s.simplifyPath("/home//foo/"));
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] strs = path.split("/");
		for (String p : strs) {
			if ("".equals(p) || ".".equals(p))
				continue;
			else if ("..".equals(p)) {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.push(p);
		}
		StringBuilder sb = new StringBuilder();
		for (String p : stack)
			sb.append('/').append(p);
		return stack.isEmpty() ? "/" : sb.toString();
	}
}