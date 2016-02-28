package round2;

import java.util.SortedSet;
import java.util.TreeSet;

public class test220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long target = t;
        if (nums.length < 2 || k < 1 || target < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= target + floor) {
                return true;
            }
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling <= target + nums[i]) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
