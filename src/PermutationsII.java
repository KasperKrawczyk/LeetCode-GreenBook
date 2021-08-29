import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp, boolean[] used){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                temp.add(nums[i]);
                used[i] = true;
                backtrack(nums, ans, temp, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
