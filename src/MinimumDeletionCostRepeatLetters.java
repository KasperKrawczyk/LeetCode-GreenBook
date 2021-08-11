public class MinimumDeletionCostRepeatLetters {

    public int minCos(String s, int[] cost){
        int curMax = cost[0];
        int curSum = cost[0];
        int ans = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) != s.charAt(i)){
                ans += curSum - curMax;
                curMax = 0;
                curSum = 0;
            }
            curSum += cost[i];
            curMax = Math.max(curMax, cost[i]);
        }
        return ans += curSum - curMax;
    }
}
