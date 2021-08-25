import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int cur){
        ans.add(new ArrayList<>(temp));
        System.out.println("CALLING cur = " + cur);
        for(int i = cur; i < nums.length; i++){
            System.out.println("i = " + i);
            temp.add(nums[i]);
            backtrack(ans, temp, nums, i + 1);
            System.out.println("remove = " + temp.get(temp.size() - 1));
            temp.remove(temp.size() - 1);
        }
        System.out.println("TEMP WITH CUR = " + cur);
        temp.forEach(a ->
                System.out.print(a + " ")
        );
        System.out.println();
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

}
