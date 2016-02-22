package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
        List<List<Integer>> ans = s.subsets(new int[]{4, 1, 0});
        System.out.println(ans);
    }

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= S.length; i++) {
            subsets(ans, S, i, 0, new ArrayList<Integer>());
        }
        return ans;
    }

    private void subsets(List<List<Integer>> ans, int[] S, int level, int pos, ArrayList<Integer> list) {
        if (level == 0) {
            ans.add((List<Integer>) list.clone());
            return;
        }
        for (int i = pos; i < S.length; i++) {
            list.add(S[i]);
            subsets(ans, S, level - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
