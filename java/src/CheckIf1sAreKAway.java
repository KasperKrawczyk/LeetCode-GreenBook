public class CheckIf1sAreKAway {
    public boolean kLengthApart(int[] nums, int k) {
        int dist = k;
        for (int num : nums) {
            if (num == 1) {
                if (k > dist) return false;
                dist = 0;
            } else {
                dist++;
            }
        }
        return true;
    }
}
