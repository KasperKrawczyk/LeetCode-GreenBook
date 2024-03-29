public class TrappingRainWater {

    // time  O(n), space O(n)
    public int trap(int[] height) {

        int n = height.length;
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        int max = 0;
        for(int i = 0; i < n; i++){
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for(int i = n - 1; i >= 0; i--){
            right[i] = max;
            max = Math.max(max, height[i]);
        }

        for(int i = 0; i < n; i++){
            ans = (Math.min(left[i], right[i]) - height[i]) > 0 ? ans + (Math.min(left[i], right[i]) - height[i]) : ans;
        }

        return ans;
    }

//    public static int trapFast(int[] height){
//        int lEdge = 0;
//        int rEdge = height.length - 1;
//
//        while(lEdge < rEdge && height[lEdge] <= height[lEdge + 1]){
//            lEdge++;
//        }
//        while(lEdge < rEdge && height[rEdge] <= height[rEdge - 1]){
//            rEdge--;
//        }
//
//        while(lEdge < rEdge){
//            int left = height[lEdge];
//            int right = height[rEdge];
//
//        }
//    }

}
