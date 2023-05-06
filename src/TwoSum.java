import java.util.*;

public class TwoSum {
    // time O(n), space O(n)
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
    // time O(n log(n)), space O(1)
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        int ind1;
        int ind2;
        int step = 0;
        while (step < nums.length) {
            ind1 = step;
            ind2 = ind1 + 1;
            step++;
            while (ind2 < nums.length) {
                if (isSum(target, nums[ind1], nums[ind2])) {
                    ans[0] = ind1;
                    ans[1] = ind2;
                    return ans;
                } else {
                    ind2++;
                }
            }
        }
        return new int[2];
    }

    private boolean isSum(int target, int val1, int val2) {
        return target == val1 + val2;
    }
}
