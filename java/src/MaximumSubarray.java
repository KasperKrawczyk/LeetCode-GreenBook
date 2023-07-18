public class MaximumSubarray {

    // time O(n), space O(1)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            maxSum = Math.max(curSum, maxSum);
            curSum = Math.max(0, curSum);
        }

        return curSum;
    }
}
