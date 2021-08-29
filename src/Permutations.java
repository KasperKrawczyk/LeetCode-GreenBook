import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // time O(n!), space O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), ans, new boolean[nums.length]);
        return ans;
    }

    private void backtrack(int[] nums, ArrayList<Integer> temp, List<List<Integer>> ans, boolean[] used){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                temp.add(nums[i]);
                used[i] = true;
                backtrack(nums, temp, ans, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

}
