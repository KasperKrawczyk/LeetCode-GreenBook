import java.util.Arrays;

public class FindPivotIndex {

    // time O(n), space O(n)
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] runSumLeft = new int[n];
        int[] runSumRight = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            runSumLeft[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            runSumRight[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (runSumRight[i + 1] == 0) {
                    return 0;
                }
                continue;
            }
            if (i == n - 1) {
                if (runSumLeft[i - 1] == 0) {
                    return n - 1;
                }
                continue;
            }
            if (runSumLeft[i - 1] == runSumRight[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // we can do better space-wise with the sum stored in a variable
    // time O(n), space O(1)
    public int pivotIndexOptimised(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int i : nums) {
            rightSum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == rightSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
