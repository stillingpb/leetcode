package round1;

public class Candy {

	public static void main(String[] args) {
		Candy c = new Candy();
		int[] ratings = { 1, 2, 2 };
		System.out.println(c.candy(ratings));
	}

	public int candy(int[] ratings) {
		int count = 0;
		int i = 0;
		while (i < ratings.length) {
			int begin = i;
			while (i < ratings.length - 1) {
				if (ratings[i] > ratings[i + 1])
					break;
				i++;
			}
			int high = i;
			while (i < ratings.length - 1) {
				if (ratings[i] < ratings[i + 1])
					break;
				i++;
			}
			int leftHigh = 1;
			for (int j = begin; j < high; j++) {
				count += leftHigh;
				if (ratings[j] < ratings[j + 1])
					leftHigh++;
				else
					leftHigh = 1;
			}
			int rightHigh = 1;
			for (int j = i; j > high; j--) {
				count += rightHigh;
				if (ratings[j - 1] > ratings[j])
					rightHigh++;
				else
					rightHigh = 1;
			}
			count += Math.max(leftHigh, rightHigh);
			if (i == ratings.length - 1)
				break;
			count--;
		}
		return count;
	}
}
