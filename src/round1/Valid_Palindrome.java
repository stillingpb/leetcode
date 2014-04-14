package round1;

import java.util.ArrayList;

//Valid Palindrome
public class Valid_Palindrome {
	public static void main(String[] args) {
		Valid_Palindrome v = new Valid_Palindrome();
		System.out.println(v.isPalindrome("a."));
		System.out.println(v.isPalindrome("aba"));
		System.out.println(v.isPalindrome("abba"));
		System.out.println(v.isPalindrome(".,"));
		System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
	}

	public boolean isPalindrome(String s) {
		ArrayList<Character> list = new ArrayList<Character>();
		for (char ch : s.toCharArray())
			if (isAlphanumeric(ch))
				list.add(ch);
		for(int i=0,j=list.size()-1;i<j;i++,j--)
			if(!isMatched(list.get(i),list.get(j)))
				return false;
		return true;
	}

	private boolean isMatched(char lf, char ri) {
		if (lf >= 'A' && lf <= 'Z')
			lf = (char) (lf - 'A' + 'a');
		if (ri >= 'A' && ri <= 'Z')
			ri = (char) (ri - 'A' + 'a');
		return lf == ri ? true : false;
	}

	private boolean isAlphanumeric(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
				|| (ch >= '0' && ch <= '9'))
			return true;
		return false;
	}
}
