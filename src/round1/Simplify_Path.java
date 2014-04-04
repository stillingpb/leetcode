package round1;

import java.util.Stack;

public class Simplify_Path {

	public static void main(String[] args) {
//		String test = "/home//foo/";
		String test = "/a/./b/../../c";
		test = new Simplify_Path().simplifyPath(test);
		System.out.println(test);

	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] splitStr = path.split("/");
		for (String str : splitStr) {
			if (".".equals(str) || "".equals(str))
				continue;
			else if ("..".equals(str)) {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.push(str);
		}
		StringBuilder sb = new StringBuilder();
		for (String s : stack)
			sb.append('/').append(s);
		return sb.length() == 0 ? "/" : sb.toString();
	}
}
