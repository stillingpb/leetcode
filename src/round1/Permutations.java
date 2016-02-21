package round1;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations p = new Permutations();
        System.out.println(p.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(ans, num, 0);
        return ans;
    }

    private void permute(List<List<Integer>> ans, int[] num, int begin) {
        if (begin == num.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : num)
                list.add(n);
            ans.add(list);
            return;
        }
        for (int i = begin; i < num.length; i++) {
            swap(num, begin, i);
            permute(ans, num, begin + 1);
            swap(num, begin, i);
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
