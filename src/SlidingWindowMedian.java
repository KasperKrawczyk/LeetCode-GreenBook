import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {
    // time O(n log m), space O(n)
    public static double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> maxTS = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> minTS = new TreeSet<>(comparator);

        double[] ans = new double[nums.length - k + 1];

        for(int i = 0; i < k; i++){
            maxTS.add(i);
        }
        balanceTreeSets(maxTS, minTS);

        ans[0] = getMedian(maxTS, minTS, nums, k);

        int idx = 1;

        for(int i = k; i < nums.length; i++){
            if(!maxTS.remove(i - k)){
                minTS.remove(i - k);
            }
            minTS.add(i);
            maxTS.add(minTS.pollFirst());
            balanceTreeSets(maxTS, minTS);
            ans[idx] = getMedian(maxTS, minTS, nums, k);
            idx++;
        }

        return ans;

    }

    private static void balanceTreeSets(TreeSet<Integer> max, TreeSet<Integer> min){
        while(max.size() > min.size()){
            min.add(max.pollFirst());
        }
    }

    private static double getMedian(TreeSet<Integer> max, TreeSet<Integer> min, int[] nums, int k){
        if(k % 2 == 0){
            return ((double) nums[max.first()] + nums[min.first()]) / 2;
        } else {
            return nums[min.first()];
        }
    }

    public static void main(String[] args) {
        double[] ans = medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(ans));
    }

}


