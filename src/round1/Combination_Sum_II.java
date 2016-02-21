package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {

    public static void main(String[] args) {
        Combination_Sum_II c = new Combination_Sum_II();
        List<List<Integer>> ans = c.combinationSum2(new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, 4);
        System.out.println(ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(ans, candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }

    private void combinationSum2(List<List<Integer>> ans, int[] candidates,
                                 int target, int level, ArrayList<Integer> list) {
        if (target == 0) {
            ans.add((ArrayList<Integer>) list.clone());
            return;
        }
        if (level >= candidates.length || candidates[level] > target) {
            return;
        } else {
            list.add(candidates[level]);
            combinationSum2(ans, candidates, target - candidates[level], level + 1, list);
            list.remove(list.size() - 1);
        }
        for (int i = level + 1; i < candidates.length; i++) {
            if (candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                return;
            list.add(candidates[i]);
            combinationSum2(ans, candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
