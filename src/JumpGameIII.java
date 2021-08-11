import java.util.*;

public class JumpGameIII {
    //time O(n), space O(n)
    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        Queue<Integer> queue = new ArrayDeque<>();


        queue.add(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            visited[cur] = true;
            if(arr[cur] == 0) return true;


            if(cur + arr[cur] < arr.length && !visited[cur + arr[cur]]){
                queue.add(cur + arr[cur]);
            }
            if(cur - arr[cur] >= 0 && !visited[cur - arr[cur]]){
                queue.add(cur - arr[cur]);
            }
        }
        return false;

    }
}
