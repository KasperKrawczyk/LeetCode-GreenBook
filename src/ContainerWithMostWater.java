public class ContainerWithMostWater {

    // bruteforce approach: time O(n^2), space O(n)
    public int maxAreaNaive(int[] height) {
        int n = height.length;
        int[] dp = new int [n];

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int smaller = Math.min(height[i], height[j]);
                int dist = Math.abs(i - j);
                if(dp[i] < smaller * dist){
                    dp[i] = smaller * dist;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    // optimised approach: time O(n), space O(1)
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;

        int ans = Integer.MIN_VALUE;

        while(i < j){
            int dist = j - i;
            int min = Math.min(height[i], height[j]);
            int cur = min * dist;
            ans = Math.max(ans, cur);
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }

}
