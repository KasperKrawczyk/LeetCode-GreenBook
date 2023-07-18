public class FirstMissingPositive {
    // time O(n), space O(1)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean isOne = false;

        for(int i : nums){
            if(i == 1){
                isOne = true;
                break;
            }
        }

        if(!isOne){
            return 1;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > n || nums[i] <= 0){
                nums[i] = 1;
            }
        }

        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]);
            if(val == n){
                nums[0] = -1 * Math.abs(nums[0]);
            } else {
                nums[val] = -1 * Math.abs(nums[val]);
            }
        }

        for(int i = 1; i < n; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        if(nums[0] > 0) {
            return n;
        }
        return n + 1;
    }
}
