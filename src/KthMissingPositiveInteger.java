public class KthMissingPositiveInteger {

    // time O(log n), space O(1)
    public static int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - mid <= k) { // (arr[mid] - mid) will indicate how many numbers
                l = mid + 1;           // are missing up and including given index
            } else {
                r = mid - 1;
            }
        }
        return l + k;
    }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

}
