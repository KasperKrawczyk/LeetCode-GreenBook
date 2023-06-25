import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // time O(n), space O(n)
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        int curMax;
        int curN;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            curN = n;
            curMax = 1;
            while (set.contains(--curN)) {
                curMax++;
                set.remove(curN);
            }
            curN = n;
            while (set.contains(++curN)) {
                curMax++;
                set.remove(curN);
            }
            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}
