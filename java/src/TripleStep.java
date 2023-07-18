import java.util.*;

/**
 * From Greenbook
 */
public class TripleStep {
    //time O(n), space O(n)
    public int countWays(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(memo, n);
    }

    private int countWays(int[] memo, int n){
        if(n < 0){
            return 0;
        } else if(n == 0){
            return 1;
        } else if(memo[n] > -1){
            return memo[n];
        } else {
            memo[n] = countWays(memo, n - 3) +
                    countWays(memo, n - 2) +
                    countWays(memo, n - 1);
            return memo[n];
        }
    }
}
