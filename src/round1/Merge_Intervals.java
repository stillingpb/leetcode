package round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Merge_Intervals {
	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static void main(String[] args) {
		int data[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		ArrayList<Interval> inte = new ArrayList<Interval>();
		for (int[] d : data) {
			inte.add(new Interval(d[0], d[1]));
		}
		Merge_Intervals m = new Merge_Intervals();
		inte = m.merge(inte);
		for (Interval i : inte)
			System.out.println(i.start + " " + i.end);
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int i = 0;
		while (i < intervals.size() - 1) {
			Interval cur = intervals.get(i);
			Interval next = intervals.get(i + 1);
			if (cur.end >= next.start) {
				cur.end = Math.max(cur.end, next.end);
				intervals.remove(i + 1);
			} else
				i++;
		}
		return intervals;
	}

}
