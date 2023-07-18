import java.util.*;

public class MaxNumberOfKSumPairs {
    // time O(n), space O(n)
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
            System.out.println(i + " || " + map.get(i));
        }
        for(int i : nums){
            if(map.containsKey(k - i) && map.get(k - i) > 0 && map.get(i) > 0){
                if(i == k - i && map.get(k - i) == 1){
                    continue;
                }
                ans++;
                map.put(i, map.get(i) - 1);
                map.put(k - i, map.get(k - i) - 1);
            }
        }
        return ans;
    }

    // we can accomplish the same with just one pass
    public int maxOperationsOnePass(int[] nums, int k){
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.getOrDefault(k - i, 0) > 0){
                map.put(k - i, map.get(k - i) - 1);
                ans++;
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return ans;
    }

    // with a sorted array, we can optimise to time O(log n), space O(1)
    public int maxOperationsSorted(int[] nums, int k){
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        Arrays.sort(nums);
        while(left < right){
            if(nums[left] + nums[right] > k){
                right--;
            } else if(nums[left] + nums[right] < k){
                left++;
            } else {
                ans++;
                left++;
                right--;
            }
        }
        return ans;
    }
}
