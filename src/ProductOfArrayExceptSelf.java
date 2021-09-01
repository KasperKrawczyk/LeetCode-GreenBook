public class ProductOfArrayExceptSelf {
    // time O(n), space O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        // for each num in nums we calculate the product of all values to its left
        // for the first num we set it to 1, as there are no values to its left
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // now, for each num in nums, we calculate the product of all values to its right and multiply it with
        // a value we already store for the num in ans[] - the product of all values to num's left
        // here we replicate the same behaviour with a dummy variable rightRunner instead of nums[nums.length - 1] = 1
        int rightRunner = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] *= rightRunner;
            rightRunner *= nums[i];
        }
        return ans;
    }
}
