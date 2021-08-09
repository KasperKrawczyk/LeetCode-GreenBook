public class MinOpsToMoveBallsToEachBox {
    public static int[] minOperationsNaive(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = boxes.charAt(i) - '0';
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                int distance = Math.abs(i - j);
                ans[i] += arr[j] * distance;
            }
        }
        return ans;
    }

    public static int[] minOperationsDP(String boxes){
        int n = boxes.length();
        int[] ans = new int[n];
        int counter = boxes.charAt(0) - '0';
        for(int i = 1; i < n; i++){
            ans[i] = ans[i - 1] + counter;
            counter += boxes.charAt(i) - '0';
        }

        for(int i : ans){
            System.out.print(i + ", ");
        }
        System.out.println();

        int step = 0;
        counter = boxes.charAt(n - 1) - '0';
        for(int i = n - 2; i >= 0; i--){
            step += counter;
            ans[i] += step;
//            ans[i] += counter;
            counter += boxes.charAt(i) - '0';
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] ans = minOperationsDP("001011");
        for(int i : ans){
            System.out.print(i + ", ");
        }
    }
}
