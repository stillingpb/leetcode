package round2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PaiLie_ZuHe {
    /**
     * 1 2
     * 2 1
     * 1 2 3
     * 1 3 2
     * 2 1 3
     * 2 3 1
     * 3 2 1
     * 3 1 2    //并不是严格的排列顺序
     * <p>
     * 1 2 3 4
     * 1 2 4 3
     * 1 3 2 4
     * 1 3 4 2
     * 1 4 2 3
     * 1 4 3 2
     * 2 1 3 4
     * 2 1 4 3
     */
    public static void main(String[] args) {
//        new PaiLie_ZuHe().pailie(new int[]{0, 1, 2, 3});
//        new PaiLie_ZuHe().zuhe(new int[]{0, 1, 2, 3});
        new PaiLie_ZuHe().getNth(new int[]{1, 2, 3,4}, 8);
    }

    void getNth(int[] num, int n) {
        if (num == null || n < 0) {
            return;
        }
        if (num.length == 1) {
            System.out.println(num[0]);
            return;
        }
        int w[] = new int[num.length];
        w[1] = 1;
        for (int i = 2; i < num.length; i++) {
            w[i] = i * w[i - 1];
        }
        if (n / w[num.length - 1] >= num.length) {
            return;
        }
        List<Integer> list = new ArrayList<>(num.length);
        for (int i : num)
            list.add(i);

        int[] ans = new int[num.length];
        for (int i = 0; i < num.length - 1; i++) {
            int idx = n / w[num.length - i - 1] ;
            ans[i] = list.remove(idx);
            n = n % w[num.length - i - 1];
        }
        ans[ans.length-1] = list.get(0);
        for (int i = 0; i < num.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    private void pailie(int[] nums) {
        pailie(nums, 0);

    }

    private void pailie(int[] nums, int k) {
        if (k == nums.length - 1) {
            print(nums);
            return;
        }
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            pailie(nums, k + 1);
            swap(nums, i, k);
        }
    }

    private void print(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    void zuhe(int[] num) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= num.length; i++) {
            zuhe(stack, num, i, 0);
        }
    }

    private void zuhe(Stack<Integer> stack, int[] num, int size, int s) {
        if (size == 0) {
            for (int i : stack) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = s; i <= num.length - size; i++) {
            stack.push(i);
            zuhe(stack, num, size - 1, i + 1);
            stack.pop();
        }
    }
}
