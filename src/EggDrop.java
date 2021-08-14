import java.util.Arrays;

public class EggDrop {

    //time O(n^2e), space(ne)
    public static int eggDrop(int n, int e){
        int[][] dp = new int[n + 1][e + 1];
        // base case with one egg
        for(int i = 0; i < n + 1; i++){
            dp[i][1] = i;
        }

        //base case with 1 floor remaining
        for(int i = 0; i < e + 1; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i < n + 1; i++){
            for(int j = 2; j < e + 1; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x < i; x++){
                    int eggBroken = dp[x - 1][j - 1];
                    int eggIntact = dp[i - x][j];
                    int worstCase = Math.max(eggBroken, eggIntact) + 1;
                    dp[i][j] = Math.min(dp[i][j], worstCase);
                }
            }
        }

        return dp[n][e];
    }


}
