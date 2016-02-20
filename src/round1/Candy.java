package round1;

/**
 * 本题 candy，还有Trapping Rain Wather，Buy And Sell Stocks twice,两个最大连续子串
 * 思想都是：从左到右，从由到左，扫2遍
 */
public class Candy {

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] ratings = {1, 2, 2};
        System.out.println(c.candy(ratings));
    }

    public int candy2(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int len = ratings.length;
        int candy[] = new int[len];
        candy[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int sum = candy[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            sum += candy[i];
        }
        return sum;
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
