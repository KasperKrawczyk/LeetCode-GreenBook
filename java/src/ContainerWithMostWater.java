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
        int left = 0;
        int right = height.length - 1;
        int width = 0;
        int cur = 0;
        int ans = 0;
        while (left < right) {
            width = right - left;
            if (height[left] <= height[right]) {
                cur = width * height[left];
                left++;
            } else {
                cur = width * height[right];
                right--;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

}
