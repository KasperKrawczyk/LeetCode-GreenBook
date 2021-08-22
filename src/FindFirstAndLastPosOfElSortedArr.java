public class FindFirstAndLastPosOfElSortedArr {
    // time O(log n), space O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findLeft(nums, target);
        ans[1] = findRight(nums, target);
        return ans;
    }

    public int findLeft(int[] nums, int target){
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if(nums[mid] == target) ans = mid;
        }
        return ans;
    }

    public int findRight(int[] nums, int target){
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if(nums[mid] == target) ans = mid;
        }
        return ans;
    }
}
