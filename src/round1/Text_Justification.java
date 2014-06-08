package round1;

import java.util.ArrayList;
import java.util.List;

public class Text_Justification {
	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification.", "sb", "sb", "sb" };
		Text_Justification t = new Text_Justification();
		List<String> ans = t.fullJustify(words, 16);

		for (String str : ans)
			System.out.println(str + "<");
	}

	public List<String> fullJustify(String[] words, int L) {
		List<String> ans = new ArrayList<String>();
		if (words.length == 0)
			return ans;
		int i = 0, begin;
		while (true) {
			begin = i;
			int wordMinLen = -1;
			while (i < words.length) {
				wordMinLen += words[i].length() + 1;
				if (wordMinLen > L)
					break;
				i++;
			}
			if (i >= words.length)
				break;
			StringBuilder spaces = new StringBuilder();
			int wordNum = i - begin;
			int wordLen = wordMinLen - wordNum - words[i].length();
			if (wordNum > 1) {
				int spacesLen = (L - wordLen) / (wordNum - 1);
				int lastLen = (L - wordLen) % (wordNum - 1); // if wordNum == 1
				for (int j = 0; j < spacesLen; j++)
					spaces.append(' ');

				StringBuilder sb = new StringBuilder();
				for (int j = begin; j < i; j++) {
					sb.append(words[j]).append(spaces);
					if (j - begin < lastLen)
						sb.append(' ');
				}
				sb.delete(sb.length() - spaces.length(), sb.length());
				ans.add(sb.toString());
			} else if (wordNum == 1) {
				StringBuilder sb = new StringBuilder();
				int spacesLen = L - words[begin].length();
				for (int j = 0; j < spacesLen; j++)
					spaces.append(' ');
				sb.append(words[begin]).append(spaces);
				ans.add(sb.toString());
			}
		}

		// last line
		StringBuilder sb = new StringBuilder();
		for (int j = begin; j < words.length; j++)
			sb.append(words[j]).append(' ');
		sb.deleteCharAt(sb.length() - 1);
		int spaceLen = L - sb.length();
		StringBuilder spaces = new StringBuilder();
		for (int j = 0; j < spaceLen; j++)
			spaces.append(' ');
		sb.append(spaces);
		ans.add(sb.toString());
		return ans;
	}
}
