package jumpgame;

public class JumpGameI {
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i > maxJump) return false;
            maxJump = Math.max(maxJump, nums[i] + i);
        }
        return true;
    }
}
