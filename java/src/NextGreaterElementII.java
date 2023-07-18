import java.util.Stack;

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

    // time o(n), space O(n)
    public int[] nextGreaterElementsFast(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            stack.push(i);
        }
        for(int i = n - 1; i >= 0; i--){
            ans[i] = -1;
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
        return ans;
    }

}
