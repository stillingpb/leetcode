package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {

    public static void main(String[] args) {
        Permutations_II p = new Permutations_II();
        System.out.println(p.permuteUnique(new int[]{1, 1, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        if (num == null && num.length == 0)
            return ans;
        Arrays.sort(num);
        helper(num, new boolean[num.length], new ArrayList<Integer>(), ans);
        return ans;
    }

    private void helper(int[] num, boolean[] used, List<Integer> item, List<List<Integer>> res) {
        if (item.size() == num.length) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && !used[i - 1] && num[i] == num[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size() - 1);
                used[i] = false;
            }
        }
    }
}
