public class JumpGameII {
    public int jump(int[] nums) {

        int numJumps = 0;
        int curMaxJump = 0;
        int curMaxDist = 0;

        for(int i = 0; i < nums.length - 1; i++){
            curMaxJump = Math.max(curMaxJump, nums[i] + i);
            if(i == curMaxDist){
                numJumps++;
                curMaxDist = curMaxJump;
            }
        }
        return numJumps;

    }
}
