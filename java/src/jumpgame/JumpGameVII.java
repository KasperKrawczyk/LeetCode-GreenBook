package jumpgame;

public class JumpGameVII {

    // time O(n), space O(n)
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        int prevPos = 0;
        dp[0] = true;

        for(int i = 1; i < n; i++){
            if(i >= minJump && dp[i - minJump]){
                prevPos++;
            }
            if(i > maxJump && dp[i - maxJump - 1]){
                prevPos--;
            }
            dp[i] = prevPos > 0 && s.charAt(i) == '0';

        }
        return dp[n - 1];
    }
}
