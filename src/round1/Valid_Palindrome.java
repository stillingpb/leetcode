package round1;

public class Valid_Palindrome {

	public static void main(String[] args) {
		System.out.println(new Valid_Palindrome()
		.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(new Valid_Palindrome()
		.isPalindrome(""));
	}

	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
				i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
				j--;
			if (i < j
					&& Character.toLowerCase(s.charAt(i++)) != Character
							.toLowerCase(s.charAt(j--)))
				return false;
		}
		return true;
	}
}
