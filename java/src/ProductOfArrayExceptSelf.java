public class ProductOfArrayExceptSelf {
    // time O(n), space O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int rightCumulativeProduct = 1; // the same purpose as ans[0] = 1 above
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = rightCumulativeProduct * ans[i];
            rightCumulativeProduct = rightCumulativeProduct * nums[i];
        }
        return ans;
    }
}
