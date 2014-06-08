package round1;

public class Reverse_Words_in_a_String {
	public static void main(String[] args) {
		Reverse_Words_in_a_String r = new Reverse_Words_in_a_String();
		System.out.println(r.reverseWords(""));
		System.out.println(r.reverseWords(" asd  dd "));
		System.out.println(r.reverseWords("  a  "));
		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(r.reverseWords("   "));
	}

	public String reverseWords(String s) {
		String[] subStr = s.trim().split(" +");
		StringBuilder sb = new StringBuilder();
		for (int i = subStr.length - 1; i >= 0; i--)
			sb.append(subStr[i]).append(' ');
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
