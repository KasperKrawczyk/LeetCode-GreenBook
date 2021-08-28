public class NextGreaterElementII {

    // time o(n^2), space O(n)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int cur = nums[i];
            int curAns = -1;
            for(int j = i + 1; j < n + i; j++){
                if(cur < nums[j % n]){
                    curAns = nums[j % n];
                    break;
                }
            }
            ans[i] = curAns;
        }
        return ans;
    }

}
