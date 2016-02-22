package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {

    public static void main(String[] args) {
        Subsets_II s = new Subsets_II();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= S.length; i++) {
            subsetsWithDup(ans, S, i, 0, new ArrayList<Integer>());
        }
        return ans;
    }

    private void subsetsWithDup(List<List<Integer>> ans, int[] S, int level, int pos, ArrayList<Integer> list) {
        if (level == 0) {
            ans.add((List<Integer>) list.clone());
            return;
        }
        for (int i = pos; i < S.length; i++) {
            if (i != pos && S[i] == S[i - 1]) {
                continue;
            }
            list.add(S[i]);
            subsetsWithDup(ans, S, level - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
