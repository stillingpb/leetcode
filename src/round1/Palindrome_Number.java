package round1;

public class Palindrome_Number {

	public static void main(String[] args) {
		Palindrome_Number p = new Palindrome_Number();
		System.out.println(p.isPalindrome(123));
		System.out.println(p.isPalindrome(-123));
		System.out.println(p.isPalindrome(0));
		System.out.println(p.isPalindrome(8));
		System.out.println(p.isPalindrome(121));
	}

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int y = 0;
		int temp = x;
		while (temp != 0) {
			y = y * 10 + temp % 10;
			temp /= 10;
		}
		return x == y;
	}
}
