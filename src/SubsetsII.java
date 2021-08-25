import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetsRecUtil(ans, new ArrayList<>(), nums, 0, false);
        return ans;
    }

    private void subsetsRecUtil(List<List<Integer>> ans, List<Integer> temp, int[] nums, int cur, boolean isPicked) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[cur]);
        subsetsRecUtil(ans, temp, nums, cur + 1, true);
        temp.remove(temp.size() - 1);

        if (cur >= 1 && nums[cur] == nums[cur - 1] && isPicked) {
            return;
        }

        subsetsRecUtil(ans, temp, nums, cur + 1, false);

    }

}
