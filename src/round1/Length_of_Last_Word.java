package round1;

public class Length_of_Last_Word {

	public static void main(String[] args) {
		Length_of_Last_Word l = new Length_of_Last_Word();
		System.out.println(l.lengthOfLastWord(" ab cd "));
	}

	public int lengthOfLastWord(String s) {
		if (s == null)
			return 0;
		int wordEnd = s.length() - 1;
		while (wordEnd >= 0 && s.charAt(wordEnd) == ' ')
			wordEnd--;
		if (wordEnd < 0)
			return 0;
		int i = wordEnd;
		for (; i >= 0; i--)
			if (s.charAt(i) == ' ')
				break;
		return wordEnd - i;
	}
}
