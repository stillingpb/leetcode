package round1;

import java.util.HashSet;

public class Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		Longest_Consecutive_Sequence l = new Longest_Consecutive_Sequence();
		System.out.println(l.longestConsecutive(new int[] { 1,2,3,100 }));
	}

	public int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : num)
			set.add(n);
		int ans = 0;
		while (set.size() != 0) {
			int cur = set.iterator().next();
			int count = 0;
			int temp = cur;
			while (set.contains(temp)) {
				set.remove(temp);
				temp--;
				count++;
			}
			temp = cur + 1;
			while (set.contains(temp)) {
				set.remove(temp);
				temp++;
				count++;
			}
			if (ans < count)
				ans = count;
		}
		return ans;
	}
}
