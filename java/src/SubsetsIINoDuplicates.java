import java.util.ArrayList;
import java.util.List;

public class SubsetsIINoDuplicates {
    public List<List<Integer>> subsetsRec(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        subsetsRecUtil(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void subsetsRecUtil(List<List<Integer>> ans, List<Integer> temp, int[] nums, int cur){
        if(cur == nums.length){
            ans.add(new ArrayList<>(temp));
            return;

        }
        if(cur == 0 || nums[cur] != nums[cur - 1]){
            temp.add(nums[cur]);
            subsetsRecUtil(ans, temp, nums, cur + 1);
            temp.remove(temp.size() - 1);
        }

        subsetsRecUtil(ans, temp, nums, cur + 1);
    }

}
