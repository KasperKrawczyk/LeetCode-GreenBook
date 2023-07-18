public class MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        int n = nums.length;
        int ops = -1; // number of operations
        int left = 0;
        int window = 0; // sliding window of the contiguous subarray

        for(int right = 0; right < n; right++){
            window += nums[right]; //update window sum

            while(window > sum - x && left <= right ){ //if window sum greater than x's complement w.r.t sum
                window -= nums[left];
                left++; // move window right
            }

            if(window == sum - x){ // if window sum equals x's complement w.r.t sum
                ops = Math.max(ops, right - left + 1);
            }
        }

        return ops == -1 ? -1 : n - ops;

    }

}
