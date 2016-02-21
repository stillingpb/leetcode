package round1;

import java.util.Arrays;

public class Next_Permutation {

    public static void main(String[] args) {
        int[][] data = {{4, 2, 0, 2, 3, 2, 0}, {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1},
                {3, 1, 2}, {3, 2, 1}};
        Next_Permutation n = new Next_Permutation();
        for (int[] d : data) {
            n.nextPermutation(d);
            for (int i : d)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public void nextPermutation(int[] num) {
        if (num.length <= 1) {
            return;
        }
        int i = num.length - 2;
        for (; i >= 0; i--) {
            if (num[i] < num[i + 1])
                break;
        }
        if (i < 0) {
            Arrays.sort(num);
            return;
        }
        int k = i;
        for (int j = i + 1; j < num.length; j++) {
            if (k == i && num[i] < num[j]) {
                k = j;
            }
            if (num[i] < num[j] && num[k] > num[j]) {
                k = j;
            }
        }
        swap(num, i, k);
        Arrays.sort(num, i + 1, num.length);
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
