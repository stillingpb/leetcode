package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {

    public static void main(String[] args) {
        Combination_Sum c = new Combination_Sum();
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(ans, candidates, target, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void combinationSum(List<List<Integer>> ans, int[] candidates, int target, ArrayList<Integer> list, int level) {
        if (target == 0) {
            ans.add((ArrayList) list.clone());
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);
            combinationSum(ans, candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}
