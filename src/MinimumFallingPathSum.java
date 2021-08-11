import java.util.*;

public class MinimumFallingPathSum {


    // time O(n log n^2), space O(n)
    public static int minFallingPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        System.arraycopy(grid[0], 0, dp, 0, n);

        for(int i = 1; i < m; i++){

            int[] nextIterationDP = new int[n];
            int[] sortedTemp = new int[n];
            System.arraycopy(dp, 0 , sortedTemp, 0, n);
            Arrays.sort(sortedTemp);

            for(int j = 0; j < n; j++){
                int min = sortedTemp[0] == dp[j] ? sortedTemp[1] : sortedTemp[0];
                nextIterationDP[j] = min + grid[i][j];
            }

            dp = nextIterationDP;

        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[j]);
        }
        return ans;
    }
    // time O(n^2), space O(n)
    public static int minFallingPathSumImproved(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        System.arraycopy(grid[0], 0, dp, 0, n);

        for(int i = 1; i < m; i++){

            int[] nextIterationDP = new int[n];
            Arrays.fill(nextIterationDP, Integer.MAX_VALUE);

            int min = Integer.MAX_VALUE - 1000;

            for(int j = 0; j < n; j++){
                nextIterationDP[j] = Math.min(nextIterationDP[j], grid[i][j] + min);
                min = Math.min(min, dp[j]);
            }

            min = Integer.MAX_VALUE - 1000;

            for(int j = n - 1; j >= 0; j--){
                nextIterationDP[j] = Math.min(nextIterationDP[j], grid[i][j] + min);
                min = Math.min(min, dp[j]);
            }

            dp = nextIterationDP;

        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[j]);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSumImproved(grid));
    }

}
