public class FindMinimumInRotatedSortedArray {
    // time O(log n), space O(1)
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l < r) {
            mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
