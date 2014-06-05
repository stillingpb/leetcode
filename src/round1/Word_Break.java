package round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Word_Break {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		String arr[] = { "a" };
		for (String str : arr)
			set.add(str);
		String s = "a";
		System.out.println(new Word_Break().wordBreak(s, set));
	}

	public boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();
		ArrayList<Integer>[] pos = new ArrayList[length];
		boolean reached = false;
		for (String str : dict) {
			int i = -1;
			while ((i = s.indexOf(str, i + 1)) != -1) {
				int end = i + str.length();
				if (end == length)
					reached = true;
				if (pos[i] == null)
					pos[i] = new ArrayList<Integer>();
				pos[i].add(end);
			}
		}
		if (!reached)
			return false;
		return dfsTraverse(pos, 0, length);
	}

	private boolean dfsTraverse(ArrayList<Integer>[] pos, int begin, int length) {
		if (pos[begin] == null)
			return false;
		for (Integer end : pos[begin]) {
			if (end == length)
				return true;
			boolean boo = dfsTraverse(pos, end, length);
			if (boo)
				return true;
		}
		return false;
	}
}
