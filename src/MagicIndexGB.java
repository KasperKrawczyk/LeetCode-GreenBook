/**
 * From Greenbook
 */

public class MagicIndexGB {
    //time O(log n), space O(1)
    public int magicIndex(int[] arr){
        return magicIndexRec(arr, 0, arr.length - 1);
    }

    private int magicIndexRec(int[] arr, int left, int right){
        if(left > right) return -1;

        int mid = (right + left) / 2;
        if(arr[mid] == mid){
            return mid;
        } else if(arr[mid] > mid){
            return magicIndexRec(arr, left, mid - 1);
        } else {
            return magicIndexRec(arr, mid + 1, right);
        }
    }
}
