import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int m = heightMap.length;
        int n = m == 0 ? 0 : heightMap[0].length;
        int ans = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            queue.add(new int[] {i, 0, heightMap[i][0]});
            queue.add(new int[] {i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for(int j = 1; j < n; j++){
            queue.add(new int[] {0, j, heightMap[0][j]});
            queue.add(new int[] {m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        while(!queue.isEmpty()){
            int[] curCell = queue.poll();

            for(int[] dir : dirs){
                int i = curCell[0] + dir[0];
                int j = curCell[1] + dir[1];
                if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;
                ans += Math.max(0, curCell[2] - heightMap[i][j]);
                queue.add(new int[] {i, j, Math.max(curCell[2], heightMap[i][j])});
                visited[i][j] = true;
            }
        }

        return ans;
    }

}
