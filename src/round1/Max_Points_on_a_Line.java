package round1;

import java.util.HashMap;
import java.util.Map;

public class Max_Points_on_a_Line {
	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) {
		int[] x = { 1, 1, 2, 2, 3 };
		int[] y = { 0, 1, 0, 1, 1 };
		Point points[] = new Point[x.length];
		for (int i = 0; i < x.length; i++)
			points[i] = new Point(x[i], y[i]);
		Max_Points_on_a_Line m = new Max_Points_on_a_Line();
		System.out.println(m.maxPoints(points));
	}

	public int maxPoints(Point[] points) {
		Map<Integer, Integer> verticals = new HashMap<Integer, Integer>(); // <x,num>
		for (Point p : points) {
			Integer numX = verticals.get(p.x);
			if (numX == null)
				verticals.put(p.x, 1);
			else
				verticals.put(p.x, numX + 1);
		}
		int maxNum = 0;
		for (Integer numX : verticals.values())
			maxNum = maxNum > numX ? maxNum : numX;

		for (int i = 0; i < points.length - 1; i++)
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x)
					continue;
				int a = points[i].x * points[j].y - points[i].y * points[j].x;
				int numLine = 0;
				for (int k = 0; k < points.length; k++)
					if ((points[i].y - points[j].y) * points[k].x + a == (points[i].x - points[j].x)
							* points[k].y)
						numLine++;
				maxNum = Math.max(maxNum, numLine);
			}
		return maxNum;
	}
}
