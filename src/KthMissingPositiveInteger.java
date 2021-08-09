public class KthMissingPositiveInteger {
    public static int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) >= k) r = mid;
            else l = mid + 1;
        }
        return l + k;
    }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

}
