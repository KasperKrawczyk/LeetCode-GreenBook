public class MaximumProductSubarray {
    // time O(n), space O(1)
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = max;
            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            ans = Math.max(max, ans);
        }

        return ans;
    }
}
