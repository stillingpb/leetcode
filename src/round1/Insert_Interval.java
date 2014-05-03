package round1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Insert_Interval {
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
		// int data[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 }
		// };
		// Interval ins = new Interval(4, 9);
		int data[][] = { { 0, 5 }, { 9, 12 } };
		Interval ins = new Interval(7, 16);
		ArrayList<Interval> inte = new ArrayList<Interval>();
		for (int[] d : data) {
			inte.add(new Interval(d[0], d[1]));
		}

		Insert_Interval in = new Insert_Interval();
		inte = in.insert(inte, ins);

		for (Interval i : inte)
			System.out.println(i.start + " " + i.end);
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int i = 0;
		for (; i < intervals.size(); i++)
			if (newInterval.start < intervals.get(i).start)
				break;
		intervals.add(i, newInterval);
		i = i == 0 ? 0 : i - 1;
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
