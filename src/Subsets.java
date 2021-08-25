import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // time O(n * 2^n), space O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int cur){
        ans.add(new ArrayList<>(temp));
        for(int i = cur; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsDFS(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : nums){
            int curSize = ans.size();
            for(int i = 0; i < curSize; i++){
                List<Integer> subset = new ArrayList<>(ans.get(i));
                subset.add(num);
                ans.add(subset);
            }
        }
        return ans;
    }

    // non-looping approach, building a binary tree, instead of an n-ary tree
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
        temp.add(nums[cur]);
        subsetsRecUtil(ans, temp, nums, cur + 1);
        temp.remove(temp.size() - 1);
        subsetsRecUtil(ans, temp, nums, cur + 1);
    }

}
