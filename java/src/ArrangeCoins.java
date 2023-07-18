public class ArrangeCoins {
    // time O(log n), space O(1)
    public int arrangeCoins(int n){
        long left = 0;
        long right = n;
        long temp;
        long mid;
        while(left <= right){
            mid = left + (right - left) / 2;

            temp = mid * (mid + 1) / 2;

            if(temp == n) return (int) mid;

            if(n < temp){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}
