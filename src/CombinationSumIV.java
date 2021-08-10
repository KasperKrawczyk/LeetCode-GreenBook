import java.util.*;

public class CombinationSumIV {
    public int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dfs(nums, target);
        return dp[target];
    }

    private int dfs(int[] nums, int target){
        if(dp[target] > -1){
            return dp[target];
        }
        int ans = 0;
        for(int i : nums){
            if(i <= target){
                ans += dfs(nums, target - i);
            }
        }
        dp[target] = ans;
        return dp[target];
    }
}
